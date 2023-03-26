package com.yash.youtube_extractor.pojo.playlist;

import com.squareup.moshi.Json;

public class AccessibilityData{

	@Json(name="label")
	private String label;

	@Json(name="accessibilityData")
	private AccessibilityData accessibilityData;

	public void setLabel(String label){
		this.label = label;
	}

	public String getLabel(){
		return label;
	}

	public void setAccessibilityData(AccessibilityData accessibilityData){
		this.accessibilityData = accessibilityData;
	}

	public AccessibilityData getAccessibilityData(){
		return accessibilityData;
	}

	@Override
 	public String toString(){
		return 
			"AccessibilityData{" + 
			"label = '" + label + '\'' + 
			",accessibilityData = '" + accessibilityData + '\'' + 
			"}";
		}
}