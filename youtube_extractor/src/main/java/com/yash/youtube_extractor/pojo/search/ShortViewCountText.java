package com.yash.youtube_extractor.pojo.search;

import com.google.gson.annotations.SerializedName;

public class ShortViewCountText{

	@SerializedName("simpleText")
	private String simpleText;

	@SerializedName("accessibility")
	private Accessibility accessibility;

	public void setSimpleText(String simpleText){
		this.simpleText = simpleText;
	}

	public String getSimpleText(){
		return simpleText;
	}

	public void setAccessibility(Accessibility accessibility){
		this.accessibility = accessibility;
	}

	public Accessibility getAccessibility(){
		return accessibility;
	}

	@Override
 	public String toString(){
		return 
			"ShortViewCountText{" + 
			"simpleText = '" + simpleText + '\'' + 
			",accessibility = '" + accessibility + '\'' + 
			"}";
		}
}