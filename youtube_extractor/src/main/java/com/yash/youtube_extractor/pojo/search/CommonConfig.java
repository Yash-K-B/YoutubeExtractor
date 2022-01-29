package com.yash.youtube_extractor.pojo.search;

import com.google.gson.annotations.SerializedName;

public class CommonConfig{

	@SerializedName("url")
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