package com.yash.youtube_extractor.pojo.search;

import com.google.gson.annotations.SerializedName;

public class ThumbnailOverlayTimeStatusRenderer{

	@SerializedName("style")
	private String style;

	@SerializedName("text")
	private Text text;

	public void setStyle(String style){
		this.style = style;
	}

	public String getStyle(){
		return style;
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
			"ThumbnailOverlayTimeStatusRenderer{" + 
			"style = '" + style + '\'' + 
			",text = '" + text + '\'' + 
			"}";
		}
}