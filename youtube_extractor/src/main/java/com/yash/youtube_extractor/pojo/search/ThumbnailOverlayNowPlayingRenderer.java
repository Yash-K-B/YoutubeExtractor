package com.yash.youtube_extractor.pojo.search;

import com.google.gson.annotations.SerializedName;

public class ThumbnailOverlayNowPlayingRenderer{

	@SerializedName("text")
	private Text text;

	public void setText(Text text){
		this.text = text;
	}

	public Text getText(){
		return text;
	}

	@Override
 	public String toString(){
		return 
			"ThumbnailOverlayNowPlayingRenderer{" + 
			"text = '" + text + '\'' + 
			"}";
		}
}