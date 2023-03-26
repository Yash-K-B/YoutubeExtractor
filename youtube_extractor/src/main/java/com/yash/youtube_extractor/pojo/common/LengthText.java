package com.yash.youtube_extractor.pojo.common;

import com.squareup.moshi.Json;
import com.yash.youtube_extractor.pojo.playlist.Accessibility;

public class LengthText{

	@Json(name="simpleText")
	private String simpleText;

	@Json(name="accessibility")
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
			"LengthText{" + 
			"simpleText = '" + simpleText + '\'' + 
			",accessibility = '" + accessibility + '\'' + 
			"}";
		}
}