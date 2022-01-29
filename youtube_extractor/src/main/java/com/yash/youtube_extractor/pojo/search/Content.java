package com.yash.youtube_extractor.pojo.search;

import com.google.gson.annotations.SerializedName;

public class Content{

	@SerializedName("verticalListRenderer")
	private VerticalListRenderer verticalListRenderer;

	public void setVerticalListRenderer(VerticalListRenderer verticalListRenderer){
		this.verticalListRenderer = verticalListRenderer;
	}

	public VerticalListRenderer getVerticalListRenderer(){
		return verticalListRenderer;
	}

	@Override
 	public String toString(){
		return 
			"Content{" + 
			"verticalListRenderer = '" + verticalListRenderer + '\'' + 
			"}";
		}
}