package com.yash.youtube_extractor.pojo.channel;

import com.squareup.moshi.Json;

public class ContentsItem{

	@Json(name = "shelfRenderer")
	private ShelfRenderer shelfRenderer;

	public void setShelfRenderer(ShelfRenderer shelfRenderer){
		this.shelfRenderer = shelfRenderer;
	}

	public ShelfRenderer getShelfRenderer(){
		return shelfRenderer;
	}

	@Override
 	public String toString(){
		return 
			"ContentsItem{" + 
			"shelfRenderer = '" + shelfRenderer + '\'' + 
			"}";
		}
}