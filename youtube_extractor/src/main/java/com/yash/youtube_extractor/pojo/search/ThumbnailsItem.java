package com.yash.youtube_extractor.pojo.search;

import com.google.gson.annotations.SerializedName;

public class ThumbnailsItem{

	@SerializedName("width")
	private Integer width;

	@SerializedName("url")
	private String url;

	@SerializedName("height")
	private Integer height;

	public void setWidth(Integer width){
		this.width = width;
	}

	public Integer getWidth(){
		return width;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	public void setHeight(Integer height){
		this.height = height;
	}

	public Integer getHeight(){
		return height;
	}

	@Override
 	public String toString(){
		return 
			"ThumbnailsItem{" + 
			"width = '" + width + '\'' + 
			",url = '" + url + '\'' + 
			",height = '" + height + '\'' + 
			"}";
		}
}