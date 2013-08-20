package com.test.searchapp;

import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class SearchResults extends Activity {

	ListView resultTable;
	ArrayList<SearchResult> results;
	ResultsAdapter adapter;
	
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
			
			return convertView;
		}
		
	}
	
}
