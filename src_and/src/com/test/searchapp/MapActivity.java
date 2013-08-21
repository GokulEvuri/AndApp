package com.test.searchapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class MapActivity extends Activity{

	ImageView bg;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.only_image_background);
	
		bg = (ImageView) findViewById(R.id.image_background);
		bg.setScaleType(ScaleType.CENTER_CROP);
		
		bg.setImageDrawable(getResources().getDrawable(R.drawable.map_dir));
		
	}
	
}
