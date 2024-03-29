package com.test.searchapp;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ListView;
import android.widget.TextView;

public class SearchResults extends Activity {

	ListView resultTable;
	ArrayList<SearchResult> results;
	ResultsAdapter adapter;
	ImageView bg;
	EditText searchField;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.result_page);
	
		results = this.getIntent().getParcelableArrayListExtra("search_results");
		
		handleAll();
		
	}
	
	public void handleAll(){
		adapter = new ResultsAdapter();
		resultTable = (ListView) findViewById(R.id.results_table);
		bg = (ImageView) findViewById(R.id.result_bg);
		searchField = (EditText) findViewById(R.id.res_search_field);
		bg.setScaleType(ScaleType.CENTER_CROP);
		
		
		searchField.setText(this.getIntent().getStringExtra("search_string"));
		bg.setImageDrawable(getResources().getDrawable(R.drawable.map));
		if(!results.isEmpty()){
			resultTable.setAdapter(adapter);
		}
	}
	
	public class ResultsAdapter extends BaseAdapter{
		
		LayoutInflater inflater;
		
		public ResultsAdapter(){
			
			inflater = (LayoutInflater) SearchResults.this
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);	
			
		}
		
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return results.size();
		}

		@Override
		public SearchResult getItem(int arg0) {
			// TODO Auto-generated method stub
			return results.get(arg0);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			convertView = inflater.inflate(R.layout.result_cell, parent, false);
			
			SearchResult item = getItem(position);
			
			//JSONObject obj = GetJSON.getObject(item.address);
			
			TextView name = (TextView) convertView.findViewById(R.id.res_name),
					storeName = (TextView) convertView.findViewById(R.id.res_store_name),
					distance = (TextView) convertView.findViewById(R.id.res_distance),
					timings = (TextView) convertView.findViewById(R.id.res_timings),
					price = (TextView) convertView.findViewById(R.id.res_price),
					phNumbers = (TextView) convertView.findViewById(R.id.res_phone);
			
			name.setText(item.name);
			storeName.setText(item.storeName);
			distance.setText(item.distance+"km");
			price.setText(item.price);
			
			timings.setText(item.timings);
			phNumbers.setText(item.phoneNumber);
			
			SetLayout.setTextColours("#ffffff", name, storeName, distance, timings, price, phNumbers);
			
			handleTouch(convertView);
			
			return convertView;
		}
		
		public void handleTouch(View convertView){
			convertView.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent intent = new Intent(SearchResults.this, MapActivity.class);
					startActivity(intent);
				}
			});
		}
		
	}
	
}
