package com.test.searchapp;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Search extends Activity {

	Button connect;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search_page);
		
		handleAll();
		handleConnect();
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
			
			String s = get.carryOut("GET","no", "http://192.168.1.3/");
			
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
