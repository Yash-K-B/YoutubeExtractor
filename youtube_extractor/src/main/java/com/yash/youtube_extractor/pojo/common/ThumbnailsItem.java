package com.yash.youtube_extractor.pojo.common;

import com.squareup.moshi.Json;

public class ThumbnailsItem{

	@Json(name="width")
	private Integer width;

	@Json(name="url")
	private String url;

	@Json(name="height")
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