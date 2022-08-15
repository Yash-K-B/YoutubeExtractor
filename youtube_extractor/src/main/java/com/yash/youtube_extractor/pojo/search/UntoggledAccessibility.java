package com.yash.youtube_extractor.pojo.search;

import com.squareup.moshi.Json;

public class UntoggledAccessibility{

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
			"UntoggledAccessibility{" + 
			"accessibilityData = '" + accessibilityData + '\'' + 
			"}";
		}
}