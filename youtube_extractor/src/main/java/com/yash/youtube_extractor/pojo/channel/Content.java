package com.yash.youtube_extractor.pojo.channel;

import com.squareup.moshi.Json;

public class Content{

	@Json(name = "horizontalListRenderer")
	private HorizontalListRenderer horizontalListRenderer;

	public void setHorizontalListRenderer(HorizontalListRenderer horizontalListRenderer){
		this.horizontalListRenderer = horizontalListRenderer;
	}

	public HorizontalListRenderer getHorizontalListRenderer(){
		return horizontalListRenderer;
	}

	@Override
 	public String toString(){
		return 
			"Content{" + 
			"horizontalListRenderer = '" + horizontalListRenderer + '\'' + 
			"}";
		}
}