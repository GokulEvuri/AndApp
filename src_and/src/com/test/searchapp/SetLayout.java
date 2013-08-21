package com.test.searchapp;

import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.ToggleButton;
import android.widget.ViewFlipper;

public class SetLayout {
		
	public static void setLayoutBelow(View v, View id)
	{
		RelativeLayout.LayoutParams p = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
		        ViewGroup.LayoutParams.WRAP_CONTENT);
		p.addRule(RelativeLayout.BELOW, id.getId());
		v.setLayoutParams(p);
	}
	
	public static void setLayoutAbove(View v, View id)
	{
		RelativeLayout.LayoutParams p = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
		        ViewGroup.LayoutParams.WRAP_CONTENT);
		p.addRule(RelativeLayout.ABOVE, id.getId());
		v.setLayoutParams(p);
	}
	
	public static void setLayoutToRightOf(View v, View id)
	{
		RelativeLayout.LayoutParams p = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
		        ViewGroup.LayoutParams.WRAP_CONTENT);
		p.addRule(RelativeLayout.RIGHT_OF, id.getId());
		v.setLayoutParams(p);
	}
	
	public static void setLayoutToLeftOf(View v, View id)
	{
		RelativeLayout.LayoutParams p = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
		        ViewGroup.LayoutParams.WRAP_CONTENT);
		p.addRule(RelativeLayout.LEFT_OF, id.getId());
		v.setLayoutParams(p);
	}
	
	public static void alignParentRight(View v)
	{
		RelativeLayout.LayoutParams p = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
		        ViewGroup.LayoutParams.WRAP_CONTENT);
		p.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
		v.setLayoutParams(p);
	}
	
	public static void alignParentLeft(View v)
	{
		RelativeLayout.LayoutParams p = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
		        ViewGroup.LayoutParams.WRAP_CONTENT);
		p.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
		v.setLayoutParams(p);
	}
	
	public static void alignParentTop(View v)
	{
		RelativeLayout.LayoutParams p = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
		        ViewGroup.LayoutParams.WRAP_CONTENT);
		p.addRule(RelativeLayout.ALIGN_PARENT_TOP);
		v.setLayoutParams(p);
	}
	
	public static void alignParentBottom(View v)
	{
		RelativeLayout.LayoutParams p = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
		        ViewGroup.LayoutParams.WRAP_CONTENT);
		p.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		v.setLayoutParams(p);
	}
	
	
	public static void setScrollViewLayout(ScrollView i, int h, int w)
	{
		if(h != 0)		i.getLayoutParams().height=h;
    	
		if(w != 0)      i.getLayoutParams().width=w;      	
	}
	
	
	public static void setScrollViewLayout(ScrollView i, int h, int w, int l, int t, int r, int b)
	{
		if(h != 0)		i.getLayoutParams().height=h;
		if(w != 0)      i.getLayoutParams().width=w;    	
    	LayoutParams params = i.getLayoutParams();
    	((MarginLayoutParams) params).setMargins(l, t, r, b);
    	i.setLayoutParams(params);
	}
	
	public static void setScrollViewLayout(ScrollView i, int l, int t, int r, int b)
	{		  	
    	LayoutParams params = i.getLayoutParams();
    	((MarginLayoutParams) params).setMargins(l, t, r, b);
    	i.setLayoutParams(params);
	}
	
	
	public static void setRelativePosition(RelativeLayout i, int x, int y)
	{
		RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(i.getWidth(), i.getHeight());
		params.leftMargin = x;
		params.topMargin = y;
		
	    i.setLayoutParams(params); 	
	}
	
	public static void setViewLayout(View i, int h, int w)
	{
		if(h != 0)		i.getLayoutParams().height=h;
    	
		if(w != 0)      i.getLayoutParams().width=w;      	
	}
	
	
	public static void setViewLayout(View i, int h, int w, int l, int t, int r, int b)
	{
		if(h != 0)		i.getLayoutParams().height=h;
		if(w != 0)      i.getLayoutParams().width=w;    	
    	LayoutParams params = i.getLayoutParams();
    	((MarginLayoutParams) params).setMargins(l, t, r, b);
    	i.setLayoutParams(params);
	}
	
	public static void setViewLayout(View i, int l, int t, int r, int b)
	{		  	
    	LayoutParams params = i.getLayoutParams();
    	((MarginLayoutParams) params).setMargins(l, t, r, b);
    	i.setLayoutParams(params);
	}
	
	
	
	public static void setCheckBoxLayout(CheckBox i, int h, int w)
	{
		if(h != 0)		i.getLayoutParams().height=h;
    	
		if(w != 0)      i.getLayoutParams().width=w;      	
	}
	
	
	public static void setCheckBoxLayout(CheckBox i, int h, int w, int l, int t, int r, int b)
	{
		if(h != 0)		i.getLayoutParams().height=h;
		if(w != 0)      i.getLayoutParams().width=w;    	
    	LayoutParams params = i.getLayoutParams();
    	((MarginLayoutParams) params).setMargins(l, t, r, b);
    	i.setLayoutParams(params);
	}
	
	public static void setCheckBoxLayout(CheckBox i, int l, int t, int r, int b)
	{		  	
    	LayoutParams params = i.getLayoutParams();
    	((MarginLayoutParams) params).setMargins(l, t, r, b);
    	i.setLayoutParams(params);
	}
	
	public static void setTextColours(String color, TextView... t){
		
		for(TextView txt: t){
			txt.setTextColor(Color.parseColor(color));
		}
		
	}

	public static void setImageLayout(ImageView i, int h, int w)
	{
		if(h != 0)		i.getLayoutParams().height=h;
    	
		if(w != 0)      i.getLayoutParams().width=w;      	
	}
	
	
	public static void setImageLayout(ImageView i, int h, int w, int l, int t, int r, int b)
	{
		if(h != 0)		i.getLayoutParams().height=h;
		if(w != 0)      i.getLayoutParams().width=w;    	
    	LayoutParams params = i.getLayoutParams();
    	((MarginLayoutParams) params).setMargins(l, t, r, b);
    	i.setLayoutParams(params);
	}
	
	public static void setImageLayout(ImageView i, int l, int t, int r, int b)
	{		  	
    	LayoutParams params = i.getLayoutParams();
    	((MarginLayoutParams) params).setMargins(l, t, r, b);
    	i.setLayoutParams(params);
	}
	
	
	
	public static void setViewPagerLayout(ViewPager i, int h, int w)
	{
		if(h != 0)		i.getLayoutParams().height=h;
    	
		if(w != 0)      i.getLayoutParams().width=w;      	
	}
	
	
	public static void setViewPagerLayout(ViewPager i, int h, int w, int l, int t, int r, int b)
	{
		if(h != 0)		i.getLayoutParams().height=h;
		if(w != 0)      i.getLayoutParams().width=w;    	
    	LayoutParams params = i.getLayoutParams();
    	((MarginLayoutParams) params).setMargins(l, t, r, b);
    	i.setLayoutParams(params);
	}
	
	public static void setViewPagerLayout(ViewPager i, int l, int t, int r, int b)
	{		  	
    	LayoutParams params = i.getLayoutParams();
    	((MarginLayoutParams) params).setMargins(l, t, r, b);
    	i.setLayoutParams(params);
	}
	
	
	public static void setGridViewLayout(GridView i, int h, int w, int l, int t, int r, int b)
	{
		if(h != 0)		i.getLayoutParams().height=h;
		if(w != 0)      i.getLayoutParams().width=w;    	
    	LayoutParams params = i.getLayoutParams();
    	((MarginLayoutParams) params).setMargins(l, t, r, b);
    	i.setLayoutParams(params);
	}
	
	public static void setGridViewLayout(GridView i, int l, int t, int r, int b)
	{		  	
    	LayoutParams params = i.getLayoutParams();
    	((MarginLayoutParams) params).setMargins(l, t, r, b);
    	i.setLayoutParams(params);
	}
	
	public static void setGridViewLayout(GridView i, int h, int w)
	{
		if(h != 0)		i.getLayoutParams().height=h;
    	
		if(w != 0)      i.getLayoutParams().width=w;      	
	}
	
	
	
	
	public static void setImageButtonLayout(ImageButton i, int h, int w, int l, int t, int r, int b)
	{
		if(h != 0)		i.getLayoutParams().height=h;
		if(w != 0)      i.getLayoutParams().width=w;    	
    	LayoutParams params = i.getLayoutParams();
    	((MarginLayoutParams) params).setMargins(l, t, r, b);
    	i.setLayoutParams(params);
	}
	
	public static void setImageButtonLayout(ImageButton i, int l, int t, int r, int b)
	{		  	
    	LayoutParams params = i.getLayoutParams();
    	((MarginLayoutParams) params).setMargins(l, t, r, b);
    	i.setLayoutParams(params);
	}
	
	public static void setImageButtonLayout(ImageButton i, int h, int w)
	{
		if(h != 0)		i.getLayoutParams().height=h;
    	
		if(w != 0)      i.getLayoutParams().width=w;      	
	}
	
	public static void setFlipperLayout(ViewFlipper i, int h, int w, int l, int t, int r, int b)
	{
		if(h != 0)		i.getLayoutParams().height=h;
		if(w != 0)      i.getLayoutParams().width=w;    	
    	LayoutParams params = i.getLayoutParams();
    	((MarginLayoutParams) params).setMargins(l, t, r, b);
    	i.setLayoutParams(params);
	}
	
	public static void setFlipperLayout(ViewFlipper i, int l, int t, int r, int b)
	{		  	
    	LayoutParams params = i.getLayoutParams();
    	((MarginLayoutParams) params).setMargins(l, t, r, b);
    	i.setLayoutParams(params);
	}
	
	public static void setFlipperLayout(ViewFlipper i, int h, int w)
	{
		if(h != 0)		i.getLayoutParams().height=h;
    	
		if(w != 0)      i.getLayoutParams().width=w;      	
	}
	
	
	public static void setTextViewLayout(TextView i, int h, int w, int l, int t, int r, int b)
	{
		if(h != 0)		i.getLayoutParams().height=h;
		if(w != 0)      i.getLayoutParams().width=w;    	
    	LayoutParams params = i.getLayoutParams();
    	((MarginLayoutParams) params).setMargins(l, t, r, b);
    	i.setLayoutParams(params);
	}
	
	public static void setTextViewLayout(TextView i, int l, int t, int r, int b)
	{
		   	
    	LayoutParams params = i.getLayoutParams();
    	((MarginLayoutParams) params).setMargins(l, t, r, b);
    	i.setLayoutParams(params);
	}
	
	public static void setTextViewLayout(TextView i, int h, int w)
	{
		if(h != 0)		i.getLayoutParams().height=h;
		if(w != 0)      i.getLayoutParams().width=w;        	
	}
	
	
	
	
	
	
	public static void setEditTextLayout(EditText i, int h, int w, int l, int t, int r, int b)
	{
		if(h != 0)		i.getLayoutParams().height=h;
		if(w != 0)      i.getLayoutParams().width=w;    	
    	LayoutParams params = i.getLayoutParams();
    	((MarginLayoutParams) params).setMargins(l, t, r, b);
    	i.setLayoutParams(params);
	}
	
	
	
	public static void setEditTextLayout(EditText i, int l, int t, int r, int b)
	{
			
    	LayoutParams params = i.getLayoutParams();
    	((MarginLayoutParams) params).setMargins(l, t, r, b);
    	i.setLayoutParams(params);
	}
	
	public static void setEditTextLayout(EditText i, int h, int w)
	{
		if(h != 0)		i.getLayoutParams().height=h;
		if(w != 0)      i.getLayoutParams().width=w;      	
	}
	
	public static void setButtonLayout(Button i, int h, int w, int l, int t, int r, int b)
	{
		if(h != 0)		i.getLayoutParams().height=h;
		if(w != 0)      i.getLayoutParams().width=w;    	
    	LayoutParams params = i.getLayoutParams();
    	((MarginLayoutParams) params).setMargins(l, t, r, b);
    	i.setLayoutParams(params);
	}
	
	public static void setButtonLayout(Button i, int l, int t, int r, int b)
	{	 	
    	LayoutParams params = i.getLayoutParams();
    	((MarginLayoutParams) params).setMargins(l, t, r, b);
    	i.setLayoutParams(params);
	}
	
	public static void setButtonLayout(Button i, int h, int w)
	{
		if(h != 0)		i.getLayoutParams().height=h;
		if(w != 0)      i.getLayoutParams().width=w;  
	}
	
	
	
	
	public static void setToggleButtonLayout(ToggleButton i, int h, int w, int l, int t, int r, int b)
	{
		if(h != 0)		i.getLayoutParams().height=h;
		if(w != 0)      i.getLayoutParams().width=w;    	
    	LayoutParams params = i.getLayoutParams();
    	((MarginLayoutParams) params).setMargins(l, t, r, b);
    	i.setLayoutParams(params);
	}
	
	public static void setToggleButtonLayout(ToggleButton i, int l, int t, int r, int b)
	{	 	
    	LayoutParams params = i.getLayoutParams();
    	((MarginLayoutParams) params).setMargins(l, t, r, b);
    	i.setLayoutParams(params);
	}
	
	public static void setToggleButtonLayout(ToggleButton i, int h, int w)
	{
		if(h != 0)		i.getLayoutParams().height=h;
		if(w != 0)      i.getLayoutParams().width=w;  
	}
	
	
	
	public static void setListLayout(ListView i, int h, int w, int l, int t, int r, int b)
	{
		if(h != 0)		i.getLayoutParams().height=h;
		if(w != 0)      i.getLayoutParams().width=w;    	
    	LayoutParams params = i.getLayoutParams();
    	((MarginLayoutParams) params).setMargins(l, t, r, b);
    	i.setLayoutParams(params);
	}
	
	public static void setListLayout(ListView i, int l, int t, int r, int b)
	{	 	
    	LayoutParams params = i.getLayoutParams();
    	((MarginLayoutParams) params).setMargins(l, t, r, b);
    	i.setLayoutParams(params);
	}
	
	public static void setListLayout(ListView i, int h, int w)
	{
		if(h != 0)		i.getLayoutParams().height=h;
		if(w != 0)      i.getLayoutParams().width=w;  
	}
	
	public static void setRelativeLayout(RelativeLayout i, int h, int w, int l, int t, int r, int b)
	{
		if(h != 0)		i.getLayoutParams().height=h;
		if(w != 0)      i.getLayoutParams().width=w;    	
    	LayoutParams params = i.getLayoutParams();
    	((MarginLayoutParams) params).setMargins(l, t, r, b);
    	i.setLayoutParams(params);
	}
	
	public static void setRelativeLayout(RelativeLayout i, int l, int t, int r, int b)
	{	 	
    	LayoutParams params = i.getLayoutParams();
    	((MarginLayoutParams) params).setMargins(l, t, r, b);
    	i.setLayoutParams(params);
	}
	
	public static void setRelativeLayout(RelativeLayout i, int h, int w)
	{
		if(h != 0)		i.getLayoutParams().height=h;
		if(w != 0)      i.getLayoutParams().width=w;  
	}

}
