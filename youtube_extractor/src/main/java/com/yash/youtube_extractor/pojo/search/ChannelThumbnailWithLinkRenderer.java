package com.yash.youtube_extractor.pojo.search;

import com.google.gson.annotations.SerializedName;

public class ChannelThumbnailWithLinkRenderer{

	@SerializedName("thumbnail")
	private Thumbnail thumbnail;

	@SerializedName("accessibility")
	private Accessibility accessibility;

	@SerializedName("navigationEndpoint")
	private NavigationEndpoint navigationEndpoint;

	public void setThumbnail(Thumbnail thumbnail){
		this.thumbnail = thumbnail;
	}

	public Thumbnail getThumbnail(){
		return thumbnail;
	}

	public void setAccessibility(Accessibility accessibility){
		this.accessibility = accessibility;
	}

	public Accessibility getAccessibility(){
		return accessibility;
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
			"ChannelThumbnailWithLinkRenderer{" + 
			"thumbnail = '" + thumbnail + '\'' + 
			",accessibility = '" + accessibility + '\'' + 
			",navigationEndpoint = '" + navigationEndpoint + '\'' + 
			"}";
		}
}