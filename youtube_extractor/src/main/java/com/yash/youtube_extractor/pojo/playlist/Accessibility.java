package com.yash.youtube_extractor.pojo.playlist;

import com.squareup.moshi.Json;

public class Accessibility{

	@Json(name="accessibilityData")
	private AccessibilityData accessibilityData;

	public void setAccessibilityData(AccessibilityData accessibilityData){
		this.accessibilityData = accessibilityData;
	}

	public AccessibilityData getAccessibilityData(){
		return accessibilityData;
	}

	@Override
 	public String toString(){
		return 
			"Accessibility{" + 
			"accessibilityData = '" + accessibilityData + '\'' + 
			"}";
		}
}