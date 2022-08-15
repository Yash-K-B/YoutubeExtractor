package com.yash.youtube_extractor.pojo.playlist;

import com.squareup.moshi.Json;

public class TopLevelButtonsItem{

	@Json(name="buttonRenderer")
	private ButtonRenderer buttonRenderer;

	public void setButtonRenderer(ButtonRenderer buttonRenderer){
		this.buttonRenderer = buttonRenderer;
	}

	public ButtonRenderer getButtonRenderer(){
		return buttonRenderer;
	}

	@Override
 	public String toString(){
		return 
			"TopLevelButtonsItem{" + 
			"buttonRenderer = '" + buttonRenderer + '\'' + 
			"}";
		}
}