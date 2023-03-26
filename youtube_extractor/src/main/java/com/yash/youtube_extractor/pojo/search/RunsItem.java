package com.yash.youtube_extractor.pojo.search;

import com.squareup.moshi.Json;

public class RunsItem{

	@Json(name="text")
	private String text;

	@Json(name="bold")
	private Boolean bold;

	@Json(name="navigationEndpoint")
	private NavigationEndpoint navigationEndpoint;

	public void setText(String text){
		this.text = text;
	}

	public String getText(){
		return text;
	}

	public void setBold(Boolean bold){
		this.bold = bold;
	}

	public Boolean isBold(){
		return bold;
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
			",bold = '" + bold + '\'' + 
			",navigationEndpoint = '" + navigationEndpoint + '\'' + 
			"}";
		}
}