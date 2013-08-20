package com.test.searchapp;

import org.json.JSONException;
import org.json.JSONObject;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

public class SearchResult implements Parcelable{
	
	String name, price, distance, storeName, phoneNumber, timings;
	
	public static final SearchParcelCreator CREATOR = new SearchParcelCreator();
	
	public static SearchResult getFromJSON(JSONObject obj) throws JSONException{
		
		//JSONObject obj = GetJSON.getObject(s);
		
		SearchResult res = new SearchResult();
		
		res.timings = obj.getJSONObject("Address").getString("OpeningTimes");
		
		res.phoneNumber = obj.getJSONObject("Address").getString("Contact");
		
		res.distance = obj.getString("Distance");
		
		//res.name = obj.getString("name");
		
		res.storeName = obj.getString("StoreName");
		
		return res;
		
	}

	public SearchResult(){
		
	}
	
	public SearchResult(Parcel src){
		name = src.readString();
		price = src.readString();
		distance = src.readString();
		storeName = src.readString();
		phoneNumber = src.readString();
		timings = src.readString();
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub
		dest.writeString(timings);
		dest.writeString(phoneNumber);
		dest.writeString(price);
		dest.writeString(distance);
		dest.writeString(storeName);
		dest.writeString(name);
	}
}
