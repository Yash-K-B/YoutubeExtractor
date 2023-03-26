package com.yash.youtube_extractor.pojo.playlist;

import com.squareup.moshi.Json;

public class ItemsItem{

	@Json(name="menuServiceItemRenderer")
	private MenuServiceItemRenderer menuServiceItemRenderer;

	public void setMenuServiceItemRenderer(MenuServiceItemRenderer menuServiceItemRenderer){
		this.menuServiceItemRenderer = menuServiceItemRenderer;
	}

	public MenuServiceItemRenderer getMenuServiceItemRenderer(){
		return menuServiceItemRenderer;
	}

	@Override
 	public String toString(){
		return 
			"ItemsItem{" + 
			"menuServiceItemRenderer = '" + menuServiceItemRenderer + '\'' + 
			"}";
		}
}