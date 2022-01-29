package com.yash.youtube_extractor.pojo.search;

import com.google.gson.annotations.SerializedName;

public class ViewCountText{

	@SerializedName("simpleText")
	private String simpleText;

	public void setSimpleText(String simpleText){
		this.simpleText = simpleText;
	}

	public String getSimpleText(){
		return simpleText;
	}

	@Override
 	public String toString(){
		return 
			"ViewCountText{" + 
			"simpleText = '" + simpleText + '\'' + 
			"}";
		}
}