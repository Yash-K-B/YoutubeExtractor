package com.yash.youtube_extractor.pojo.search;

import com.squareup.moshi.Json;

public class AccessibilityData{

	@Json(name="label")
	private String label;

	public void setLabel(String label){
		this.label = label;
	}

	public String getLabel(){
		return label;
	}

	@Override
 	public String toString(){
		return 
			"AccessibilityData{" + 
			"label = '" + label + '\'' + 
			"}";
		}
}