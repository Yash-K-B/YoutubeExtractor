package com.yash.youtube_extractor.pojo.channel;

import com.squareup.moshi.Json;

public class ThumbnailOverlayNowPlayingRenderer{

	@Json(name = "text")
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