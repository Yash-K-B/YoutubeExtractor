package com.yash.youtube_extractor.pojo.channel;

import com.squareup.moshi.Json;

public class Icon{

	@Json(name = "iconType")
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
			"Icon{" + 
			"iconType = '" + iconType + '\'' + 
			"}";
		}
}