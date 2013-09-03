package com.test.searchapp;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.util.EntityUtils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;

public class PostData extends AsyncTask<String, Void, String>{
	
	Context c = null;
	SharedPreferences yp = null;
	
	PostData(Context c)
	{
		this.c = c;
		yp = c.getSharedPreferences("tokens", Context.MODE_PRIVATE);
	}

	@Override
	protected String doInBackground(String... params) {
		// TODO Auto-generated method stub
				
		String s = null;
		
		HttpClient httpclient = new DefaultHttpClient();
	    httpclient.getParams().setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);

	    HttpPost httppost = new HttpPost(params[0]);
	   
	    HttpResponse response = null;
		try {
			response = httpclient.execute(httppost);
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
			System.out.println(EntityUtils.toString(resEntity));
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
	    
	    return resEntity.toString();
	}
	
	public String carryOut(String...params)
	{
		String s = null;
		
		HttpClient httpclient = new DefaultHttpClient();
	    httpclient.getParams().setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);

	    HttpPost httppost = new HttpPost(params[0]);
	   
	   // System.out.println("executing request " + httppost.getRequestLine());
	    HttpResponse response = null;
		try {
			response = httpclient.execute(httppost);
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
			//System.out.println(EntityUtils.toString(resEntity));
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
	    
	    if(resEntity == null){
	    	
	    	s = "Failure Response";
	    }
	    
	    
	    return s;
	}

}
