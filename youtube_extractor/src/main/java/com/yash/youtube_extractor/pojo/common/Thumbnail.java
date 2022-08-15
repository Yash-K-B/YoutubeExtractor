package com.yash.youtube_extractor.pojo.common;

import com.squareup.moshi.Json;

import java.util.List;

public class Thumbnail{

	@Json(name="thumbnails")
	private List<ThumbnailsItem> thumbnails;

	public void setThumbnails(List<ThumbnailsItem> thumbnails){
		this.thumbnails = thumbnails;
	}

	public List<ThumbnailsItem> getThumbnails(){
		return thumbnails;
	}

	@Override
 	public String toString(){
		return 
			"Thumbnail{" + 
			"thumbnails = '" + thumbnails + '\'' + 
			"}";
		}
}