package com.yash.youtube_extractor.pojo.channel;

import com.squareup.moshi.Json;

public class PreviousButton{

	@Json(name = "buttonRenderer")
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
			"PreviousButton{" + 
			"buttonRenderer = '" + buttonRenderer + '\'' + 
			"}";
		}
}