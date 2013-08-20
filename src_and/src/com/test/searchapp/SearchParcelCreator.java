package com.test.searchapp;

import android.os.Parcel;
import android.os.Parcelable;

public class SearchParcelCreator implements Parcelable.Creator<SearchResult> {
    public SearchResult createFromParcel(Parcel source) {
        return new SearchResult(source);
  }

	@Override
	public SearchResult[] newArray(int size) {
		// TODO Auto-generated method stub
		return new SearchResult[size];
	}
  
}
