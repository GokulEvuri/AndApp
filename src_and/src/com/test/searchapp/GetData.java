package com.test.searchapp;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

import android.os.AsyncTask;
import android.util.Log;

public class GetData extends AsyncTask<String, Void, String>{
	
	public String carryOut(String... params)
	{
		String s = null;
		
		HttpClient httpclient = new DefaultHttpClient();
	    httpclient.getParams().setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);

	    HttpGet httppost = new HttpGet(params[2]);
	     
	    CookieStore store = new BasicCookieStore();
	       
	    BasicClientCookie a, b;
	    
	    if(params[1].matches("yes"))
	    {	
	    	if(params.length==6)
	    	{
	    	 a = new BasicClientCookie(params[4], params[5]);
	  	   
	 	    a.setDomain(".youpic.com");
	 	    a.setPath("/");
	 	    
	 	   store.addCookie(a);
	    	}else if(params.length==8)
	    	{
	    		 a = new BasicClientCookie(params[4], params[5]);
	  	  	   
	 	 	    a.setDomain(".youpic.com");
	 	 	    a.setPath("/");
	 	 	    
	 	 	   store.addCookie(a);
	    		
	    		 b = new BasicClientCookie(params[6], params[7]);
	  	 	   
	 	 	    b.setDomain(".youpic.com");
	 	 	    b.setPath("/");	 	 	    
	 	 	    
	 	 	    store.addCookie(b);	 	
	    	}	 	       
	    }	    
	   
	    HttpContext ctx = new BasicHttpContext();
	    ctx.setAttribute(ClientContext.COOKIE_STORE, store);
	   	    
	    HttpParams httpParameters = new BasicHttpParams();
		
	 // Set the timeout in milliseconds until a connection is established.
	 // The default value is zero, that means the timeout is not used. 
	    int timeoutConnection = 3000;
	    HttpConnectionParams.setConnectionTimeout(httpParameters, timeoutConnection);
	    // Set the default socket timeout (SO_TIMEOUT) 
	    // in milliseconds which is the timeout for waiting for data.
	    int timeoutSocket = 5000;
	    HttpConnectionParams.setSoTimeout(httpParameters, timeoutSocket);
	    
	    
	    HttpResponse response = null;
		try {
			response = httpclient.execute(httppost, ctx);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			
			s = "Failure Response";
			
			e.printStackTrace();
			
			return s;
		}
	    HttpEntity resEntity = response.getEntity();

	    System.out.println(response.getStatusLine());
	    if (resEntity != null) {
	      try {
			 s = EntityUtils.toString(resEntity);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	    }
	    if (resEntity != null) {
	      try {
			resEntity.consumeContent();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    }else{
	    	s = "Failed Response";
	    }

	    httpclient.getConnectionManager().shutdown();
	    
	    Log.d("GET", "status - "+response.getStatusLine().getStatusCode());
	    if(response.getStatusLine().getStatusCode()==404){
	    	s = "Failed Response"; 
	    }
	    
	    return s;
	}

	@Override
	protected String doInBackground(String... params) {
		// TODO Auto-generated method stub
		
	String s = null;
		
		HttpClient httpclient = new DefaultHttpClient();
	    httpclient.getParams().setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);

	    HttpGet httppost = new HttpGet(params[2]);
	     
	    CookieStore store = new BasicCookieStore();
	       
	    BasicClientCookie a, b;
	    
	    if(params[1].matches("yes"))
	    {
	    	 a = new BasicClientCookie("session_token", params[5]);
	  	   
	 	    a.setDomain(".youpic.com");
	 	    a.setPath("/");
	 	   
	 	    b = new BasicClientCookie("security_token", params[7]);
	 	   
	 	    b.setDomain(".youpic.com");
	 	    b.setPath("/");
	 	    
	 	    store.addCookie(a);
	 	    store.addCookie(b);	 	    
	    }	    
	   
	    HttpContext ctx = new BasicHttpContext();
	    ctx.setAttribute(ClientContext.COOKIE_STORE, store);
	   	    
	    
	    HttpResponse response = null;
		try {
			response = httpclient.execute(httppost, ctx);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    HttpEntity resEntity = response.getEntity();

	    System.out.println(response.getStatusLine());
	    if (resEntity != null) {
	      try {
			 s = EntityUtils.toString(resEntity);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    }
	    if (resEntity != null) {
	      try {
			resEntity.consumeContent();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    }

	    httpclient.getConnectionManager().shutdown();
	    
	    return s;
	}

}
