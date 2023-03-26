package com.yash.youtube_extractor.pojo.channel;

import com.squareup.moshi.Json;

public class PublishedTimeText{

	@Json(name = "simpleText")
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
			"PublishedTimeText{" + 
			"simpleText = '" + simpleText + '\'' + 
			"}";
		}
}