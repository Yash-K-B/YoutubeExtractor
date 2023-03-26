package com.yash.youtube_extractor.pojo.channel;

import com.squareup.moshi.Json;

public class ThumbnailOverlaySidePanelRenderer{

	@Json(name = "icon")
	private Icon icon;

	@Json(name = "text")
	private Text text;

	public void setIcon(Icon icon){
		this.icon = icon;
	}

	public Icon getIcon(){
		return icon;
	}

	public void setText(Text text){
		this.text = text;
	}

	public Text getText(){
		return text;
	}

	@Override
 	public String toString(){
		return 
			"ThumbnailOverlaySidePanelRenderer{" + 
			"icon = '" + icon + '\'' + 
			",text = '" + text + '\'' + 
			"}";
		}
}