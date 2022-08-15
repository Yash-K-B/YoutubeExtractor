package com.yash.youtube_extractor.pojo.search;

import com.squareup.moshi.Json;
import com.yash.youtube_extractor.pojo.common.Thumbnail;

public class ChannelThumbnailWithLinkRenderer{

	@Json(name="thumbnail")
	private Thumbnail thumbnail;

	@Json(name="accessibility")
	private Accessibility accessibility;

	@Json(name="navigationEndpoint")
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