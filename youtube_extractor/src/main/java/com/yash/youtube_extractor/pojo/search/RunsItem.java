package com.yash.youtube_extractor.pojo.search;

import com.google.gson.annotations.SerializedName;

public class RunsItem{

	@SerializedName("text")
	private String text;

	@SerializedName("bold")
	private Boolean bold;

	@SerializedName("navigationEndpoint")
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