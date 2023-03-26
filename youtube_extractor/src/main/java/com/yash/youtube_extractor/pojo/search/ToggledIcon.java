package com.yash.youtube_extractor.pojo.search;

import com.squareup.moshi.Json;

public class ToggledIcon{

	@Json(name="iconType")
	private String iconType;

	public void setIconType(String iconType){
		this.iconType = iconType;
	}

	public String getIconType(){
		return iconType;
	}

	@Override
 	public String toString(){
		return 
			"ToggledIcon{" + 
			"iconType = '" + iconType + '\'' + 
			"}";
		}
}