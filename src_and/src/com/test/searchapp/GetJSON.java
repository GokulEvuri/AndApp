package com.test.searchapp;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class GetJSON {
	
	public static JSONObject getObject(String s){
		
		JSONObject obj = null;
		
		JSONTokener tok = null;
		
		tok = new JSONTokener(s);
		
		try {
			obj = new JSONObject(tok);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return obj;
	}
	
	public static JSONArray getArray(String s){
		
		JSONArray obj = null;
		
		JSONTokener tok = new JSONTokener(s);
		
		try {
			obj = new JSONArray(tok);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return obj;
	}

}
