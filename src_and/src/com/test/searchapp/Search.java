package com.test.searchapp;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;

public class Search extends FragmentActivity {

	static final LatLng HAMBURG = new LatLng(53.558, 9.927);
	static final LatLng KIEL = new LatLng(53.551, 9.993);
	Button connect, categories;
	//private GoogleMap map;
	ListView searchTable;
	EditText searchField;
	ImageView bg;
	RelativeLayout searchBox;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search_page);
		
		handleAll();
		
		handleConnect();
		
		handleCategories();
		
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
		categories = (Button) findViewById(R.id.test_cats);
		searchTable = (ListView) findViewById(R.id.test_table);
		bg = (ImageView) findViewById(R.id.test_bg);
		searchBox = (RelativeLayout) findViewById(R.id.search_box);
		searchField = (EditText) findViewById(R.id.test_search_field);
		
		searchBox.setBackgroundColor(Color.parseColor("#bbffffff"));
		
		bg.setScaleType(ScaleType.CENTER_CROP);
		
		bg.setImageDrawable(getResources().getDrawable(R.drawable.map));
	}
	
	public void handleConnect(){
		connect.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Log.d("RBUTTON", "clicked");
				
				GetResponse get = new GetResponse();
				
				get.execute();
				
				//Intent share = new Intent(Search.this, FacebookHandler.class);
				
				//share.putExtra("login", true);
				//Search.this.startActivity(share);
			}
		});
	}
	
	public void handleCategories(){
		categories.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				SearchAdapter search = new SearchAdapter(DataArray.allThings, false);
				searchTable.setAdapter(search);
				
			}
		});
	}

	public class GetResponse extends AsyncTask<Void, String, String>{

		@Override
		protected String doInBackground(Void... arg0) {
			// TODO Auto-generated method stub
			
			Log.d("GET", "sending request");
			
			GetData get = new GetData();
			
			String s = get.carryOut("GET","no", "http://192.168.1.4/req?item=chips&latitude=-2.0&longitude=-7.1");
			
			return s;
		}
		
		@Override
		public void onPostExecute(String res){
			if(res.matches("Failure Response")){
	    		
				Toast t = Toast.makeText(getApplicationContext(), "Bad Internet Connection", Toast.LENGTH_SHORT);
	        	t.show();
			}else{
				Log.d("RESPONSE", "response.. "+res);
				try {
					storeSearchResults(res);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public void storeSearchResults(String res) throws JSONException{
		
		ArrayList<SearchResult> results = new ArrayList<SearchResult>();
		
		JSONArray arr = GetJSON.getArray(res);
		
		for(int i = 0; i<arr.length(); i++){
			
			SearchResult temp = SearchResult.getFromJSON(arr.getJSONObject(i));
			
			results.add(temp);
		}
		
		if(!results.isEmpty()){
			Intent intent = new Intent(Search.this, SearchResults.class);
			
			//if(!TextUtils.isEmpty(searchField.getText())){
				intent.putExtra("search_string", searchField.getText().toString());
			//}
			
			intent.putExtra("search_results", results);
			startActivity(intent);
		}
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.search_page, menu);
		return true;
	}
	
	public class SearchAdapter extends BaseAdapter{

		LayoutInflater inflater;
		List<String> localArray;
		boolean json = false;
		
		SearchAdapter(List<String> arr, boolean json){
			this.localArray = arr;
			this.json = json;
			inflater = (LayoutInflater) Search.this
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);	
		}
		
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return localArray.size();
		}

		@Override
		public String getItem(int position) {
			// TODO Auto-generated method stub
			return localArray.get(position);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			
			convertView = inflater.inflate(R.layout.search_cell, parent, false);
			
			TextView text = (TextView) convertView.findViewById(R.id.sc_text);
			
			text.setText(getItem(position));
			
			SetLayout.setViewLayout(searchTable, convertView.getHeight()*getCount(), convertView.getWidth());
			
			handleSelect(convertView, getItem(position));
			
			return convertView;
		}
		
		public void handleSelect(View convertView, final String s){
			convertView.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
					if(json){
						for(List<String> arr: DataArray.allArrays){
							
							if(arr.get(0).matches(s)){
								
								SearchAdapter search = new SearchAdapter(arr.subList(1, arr.size()), false);
								searchTable.setAdapter(search);
								break;
							}
						}
					}else{
						
					}
				}
			});
		}
		
	}

}
