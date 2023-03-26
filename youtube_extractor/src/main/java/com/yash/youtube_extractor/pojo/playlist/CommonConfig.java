package com.yash.youtube_extractor.pojo.playlist;

import com.squareup.moshi.Json;

public class CommonConfig{

	@Json(name="url")
	private String url;

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	@Override
 	public String toString(){
		return 
			"CommonConfig{" + 
			"url = '" + url + '\'' + 
			"}";
		}
}