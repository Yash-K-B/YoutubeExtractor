package com.yash.youtube_extractor.pojo.playlist;

import com.squareup.moshi.Json;

public class Menu{

	@Json(name="menuRenderer")
	private MenuRenderer menuRenderer;

	public void setMenuRenderer(MenuRenderer menuRenderer){
		this.menuRenderer = menuRenderer;
	}

	public MenuRenderer getMenuRenderer(){
		return menuRenderer;
	}

	@Override
 	public String toString(){
		return 
			"Menu{" + 
			"menuRenderer = '" + menuRenderer + '\'' + 
			"}";
		}
}