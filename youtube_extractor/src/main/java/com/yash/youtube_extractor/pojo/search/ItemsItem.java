package com.yash.youtube_extractor.pojo.search;

import com.squareup.moshi.Json;

public class ItemsItem{

	@Json(name="menuServiceItemRenderer")
	private MenuServiceItemRenderer menuServiceItemRenderer;

	@Json(name="videoRenderer")
	private VideoRenderer videoRenderer;

	public void setMenuServiceItemRenderer(MenuServiceItemRenderer menuServiceItemRenderer){
		this.menuServiceItemRenderer = menuServiceItemRenderer;
	}

	public MenuServiceItemRenderer getMenuServiceItemRenderer(){
		return menuServiceItemRenderer;
	}

	public void setVideoRenderer(VideoRenderer videoRenderer){
		this.videoRenderer = videoRenderer;
	}

	public VideoRenderer getVideoRenderer(){
		return videoRenderer;
	}

	@Override
 	public String toString(){
		return 
			"ItemsItem{" + 
			"menuServiceItemRenderer = '" + menuServiceItemRenderer + '\'' + 
			",videoRenderer = '" + videoRenderer + '\'' + 
			"}";
		}
}