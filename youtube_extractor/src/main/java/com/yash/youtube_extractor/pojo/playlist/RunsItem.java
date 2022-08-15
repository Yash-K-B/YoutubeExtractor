package com.yash.youtube_extractor.pojo.playlist;

import com.squareup.moshi.Json;

public class RunsItem{

	@Json(name="text")
	private String text;

	@Json(name="navigationEndpoint")
	private NavigationEndpoint navigationEndpoint;

	public void setText(String text){
		this.text = text;
	}

	public String getText(){
		return text;
	}

	public void setNavigationEndpoint(NavigationEndpoint navigationEndpoint){
		this.navigationEndpoint = navigationEndpoint;
	}

	public NavigationEndpoint getNavigationEndpoint(){
		return navigationEndpoint;
	}

	@Override
 	public String toString(){
		return 
			"RunsItem{" + 
			"text = '" + text + '\'' + 
			",navigationEndpoint = '" + navigationEndpoint + '\'' + 
			"}";
		}
}