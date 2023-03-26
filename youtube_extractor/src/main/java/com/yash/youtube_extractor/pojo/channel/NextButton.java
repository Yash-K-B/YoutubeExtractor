package com.yash.youtube_extractor.pojo.channel;

import com.squareup.moshi.Json;

public class NextButton{

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
			"NextButton{" + 
			"buttonRenderer = '" + buttonRenderer + '\'' + 
			"}";
		}
}