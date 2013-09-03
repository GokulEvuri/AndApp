package com.test.searchapp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.Toast;

import com.facebook.Request;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.Session.NewPermissionsRequest;
import com.facebook.Session.OpenRequest;
import com.facebook.SessionLoginBehavior;
import com.facebook.SessionState;
import com.facebook.UiLifecycleHelper;
import com.facebook.model.GraphUser;


public class FacebookHandler extends Activity{
	
	public static final String LOGIN = "login";
	public static final String COUNT = "count";
	public static final String USER = "username";
	public static final String PASS = "password";
	public static final String USER_ID = "user_id";
	
	public static final String SESSION = "session";
	public static final String SECURITY = "security";
	
	Boolean loggedIn = false;
	
	private static final List<String> PERMISSIONS = Arrays.asList("publish_actions");
	private static final String PENDING_PUBLISH_KEY = "pendingPublishReauthorization";
	private boolean pendingPublishReauthorization = false;
	
	ImageView background;
	ProgressDialog dialog;
	UiLifecycleHelper helper;
	
	 @Override
	    public void onCreate(Bundle savedInstanceState) { 
	        super.onCreate(savedInstanceState);
	        dialog = new ProgressDialog(FacebookHandler.this);
	       // YPApp.add(FacebookHandler.this);
	        setContentView(R.layout.only_image_background);
	        
	        background = (ImageView) findViewById(R.id.image_background);
	        background.setScaleType(ScaleType.CENTER_CROP); 
	        
	        Boolean login = getIntent().getBooleanExtra("login", false),
	        		logout = getIntent().getBooleanExtra("logout", false);
	        
	        if(login){
	        	dialog.setMessage("Logging into Facebook...");         
	       	    dialog.show();  
	        	doFacebookLogin();
	        }else if(logout){
	        	doFacebookLogout();
	        }
	       
	    }
	 
	 
	 
	    @Override
	    protected void onStart()
	    {
	    	super.onStart();
	    	
	    }
	     
	    @Override
	    protected void onStop()
	    {
	    	super.onStop();
	    	
	    	if(dialog.isShowing()){
	    		dialog.cancel();
	    	}
	    	
	    }
	 
	    public void doFacebookLogout(){
	    	
	    	Session session = Session.openActiveSessionFromCache(getApplicationContext());
	    	
	    	if(session!=null){
	    		
	    		session.closeAndClearTokenInformation();
	    	}
	    	//.closeAndClearTokenInformation();
	    	
	    	Intent myIntent = new Intent( this, Search.class);
	        startActivity(myIntent);
	        
	        FacebookHandler.this.finish();
	    }
	    
	    public boolean facebookAppInstalled(){
	    	try{
	    	    ApplicationInfo info = getPackageManager().
	    	            getApplicationInfo("com.facebook.katana", 0 );
	    	    return true;
	    	} catch( PackageManager.NameNotFoundException e ){
	    	    return false;
	    	}
	    }
	    
	    public void doFacebookLogin(){
	    	
	    
	    	
	    	if(facebookAppInstalled()){
	    		Session.openActiveSession(this, true, new Session.StatusCallback() {

		            // callback when session changes state
		            @Override
		            public void call(final Session session, SessionState state, Exception exception) {
		            	
		            	if(!loggedIn){
		            		if(session.isOpened()){
			            		// make request to the /me API
			         
			            		
			            		Request.executeMeRequestAsync(session, new Request.GraphUserCallback() {

			            		  // callback after Graph API response with user object
			            		  @Override
			            		  public void onCompleted(GraphUser user, Response response) {
			            			  
			            			  //Log.d("FB_PERMISSIONS", "permissions "+session.getPermissions());
			            			 
			            				  OpenRequest openRequest = new OpenRequest(FacebookHandler.this);
				            			  List<String> readPermissions = new ArrayList<String>();
				            			  readPermissions.add("email");
				            			  openRequest.setPermissions(readPermissions);
				            			  openRequest.setLoginBehavior(SessionLoginBehavior.SSO_WITH_FALLBACK);
				            			  //openRequest.setCallback();
				            			  NewPermissionsRequest rp = new NewPermissionsRequest(FacebookHandler.this,readPermissions);
				            			 
				            			  session.requestNewReadPermissions(rp);
				            			  
				            			  //Log.d("FB", "accesstoken - "+session.getAccessToken()+", email - "+user.getInnerJSONObject());
				            			  
				            			  SharedPreferences yp = getSharedPreferences(LOGIN, Context.MODE_PRIVATE);
				  			            
				  			    	    SharedPreferences.Editor Ed = yp.edit();
				  			    	    Ed.putString(USER, user.getUsername());              
				  			    	   
				  			    	    Ed.commit();
				            			  
				            			String accessToken = Session.getActiveSession().getAccessToken();
				            			
			            			  Log.d("FB", "logged in as "+user.getUsername());
			            		  }
			            		});
			            	}else{
			            		
			            		//YPApp.finishAll();
			            		//Toast t = Toast.makeText(getApplicationContext(), "Facebook Login error", Toast.LENGTH_LONG);
			            		//t.show();
			            		//FacebookHandler.this.finish();
			            	}
		            	}
		            }
		          });
	    	}else{
	    		
	    		if(dialog.isShowing()){
	    			dialog.cancel();
	    		}
	    		Toast t = Toast.makeText(getApplicationContext(), "Please install Facebook App and try again", Toast.LENGTH_LONG);
        		t.show();
        		
        		FacebookHandler.this.finish();
	    	}
	    	
	    	
	    }
	    
	    @Override
	    public void onActivityResult(int requestCode, int resultCode, Intent data) {
	      super.onActivityResult(requestCode, resultCode, data);
	      
	      
	      Session.getActiveSession().onActivityResult(this, requestCode, resultCode, data);
	    }
	    
	   
		
	    @Override
	    public void onSaveInstanceState(Bundle outState) {
	        super.onSaveInstanceState(outState);
	        
	        
	        outState.putBoolean(PENDING_PUBLISH_KEY, pendingPublishReauthorization);
	        //uiHelper.onSaveInstanceState(outState);
	    }
	    
	    //public void handleShare(final ImageDetails img){
	    	
	    //}
	    
	    /*
	 public void handleFacebook(final Object img)
	{	
		 Session.openActiveSessionFromCache(getApplicationContext());
		
		 Bundle params = new Bundle();
		    params.putString("name", img.imageName+" by "+img.userName);
		    params.putString("caption", "Check this photo out!");
		    params.putString("description", "YouPic. Inspiration for photography.");
		    params.putString("link", "https://youpic.com/image/"+img.imageID);
		    params.putString("picture", img.smallURL);
		    
		    WebDialog feedDialog = (
		        new WebDialog.FeedDialogBuilder(FacebookHandler.this,
		            Session.getActiveSession(),
		            params))
		        .setOnCompleteListener(new OnCompleteListener() {

		            @Override
		            public void onComplete(Bundle values,
		                FacebookException error) {
		                if (error == null) {
		                    // When the story is posted, echo the success
		                    // and the post Id.
		                    final String postId = values.getString("post_id");
		                    if (postId != null) {
		                        Toast.makeText(FacebookHandler.this,
		                            "Posted image to feed",
		                            Toast.LENGTH_SHORT).show();
		                        
		                        FacebookHandler.this.finish();
		                        
		                    } else {
		                        // User clicked the Cancel button
		                        Toast.makeText(FacebookHandler.this.getApplicationContext(), 
		                            "Publish cancelled", 
		                            Toast.LENGTH_SHORT).show();
		                        
		                        FacebookHandler.this.finish();
		                    }
		                } else if (error instanceof FacebookOperationCanceledException) {
		                    // User clicked the "x" button
		                    Toast.makeText(FacebookHandler.this.getApplicationContext(), 
		                        "Publish cancelled", 
		                        Toast.LENGTH_SHORT).show();
		                    
		                    FacebookHandler.this.finish();
		                } else {
		                    // Generic, ex: network error
		                    Toast.makeText(FacebookHandler.this.getApplicationContext(), 
		                        "Error posting story", 
		                        Toast.LENGTH_SHORT).show();
		                    
		                    FacebookHandler.this.finish();
		                }
		            }

		        })
		        .build();
		    feedDialog.show();

							
	}*/
		


}
