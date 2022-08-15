package com.yash.youtube_extractor.pojo.channel;

import com.squareup.moshi.Json;

public class RunsItem{

	@Json(name = "text")
	private String text;

	@Json(name = "navigationEndpoint")
	private NavigationEndpoint navigationEndpoint;

	@Json(name = "bold")
	private Boolean bold;

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

	public void setBold(Boolean bold){
		this.bold = bold;
	}

	public Boolean isBold(){
		return bold;
	}

	@Override
 	public String toString(){
		return 
			"RunsItem{" + 
			"text = '" + text + '\'' + 
			",navigationEndpoint = '" + navigationEndpoint + '\'' + 
			",bold = '" + bold + '\'' + 
			"}";
		}
}