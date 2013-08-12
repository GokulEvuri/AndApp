package com.test.searchapp;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;

public class Search extends FragmentActivity {

	static final LatLng HAMBURG = new LatLng(53.558, 9.927);
	static final LatLng KIEL = new LatLng(53.551, 9.993);
	Button connect;
	//private GoogleMap map;
	ListView searchTable;
	EditText searchField;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search_page);
		
		handleAll();
		handleConnect();
		
		/*map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
		        .getMap();
		
		 Marker hamburg = map.addMarker(new MarkerOptions().position(HAMBURG)
			        .title("Hamburg"));
			    Marker kiel = map.addMarker(new MarkerOptions()
			        .position(KIEL)
			        .title("Kiel")
			        .snippet("Kiel is cool")
			        .icon(BitmapDescriptorFactory
			            .fromResource(R.drawable.ic_launcher)));

			    // Move the camera instantly to hamburg with a zoom of 15.
			    map.moveCamera(CameraUpdateFactory.newLatLngZoom(HAMBURG, 15));

			    // Zoom in, animating the camera.
			    map.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);*/
	}

	public void handleAll(){
		connect = (Button) findViewById(R.id.test_button);
	}
	
	public void handleConnect(){
		connect.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				GetResponse get = new GetResponse();
				
				get.execute();
				
			}
		});
	}
	

	public class GetResponse extends AsyncTask<Void, String, String>{

		@Override
		protected String doInBackground(Void... arg0) {
			// TODO Auto-generated method stub
			
			Log.d("GET", "sending request");
			
			GetData get = new GetData();
			
			String s = get.carryOut("GET","no", "http://46.239.104.192/post.yaws");
			
			return s;
		}
		
		@Override
		public void onPostExecute(String res){
			if(res.matches("Failure Response")){
	    		
				Toast t = Toast.makeText(getApplicationContext(), "Bad Internet Connection", Toast.LENGTH_SHORT);
	        	t.show();
			}else{
				Log.d("RESPONSE", "response.. "+res);
			}
		}
		
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.search_page, menu);
		return true;
	}

}
