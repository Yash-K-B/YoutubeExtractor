package com.yash.youtube_extractor.pojo.channel;

import com.squareup.moshi.Json;

public class Accessibility{

	@Json(name = "label")
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
			"Accessibility{" + 
			"label = '" + label + '\'' + 
			"}";
		}
}