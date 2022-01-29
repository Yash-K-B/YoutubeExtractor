package com.yash.youtube_extractor.pojo.search;

import com.google.gson.annotations.SerializedName;

public class Menu{

	@SerializedName("menuRenderer")
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