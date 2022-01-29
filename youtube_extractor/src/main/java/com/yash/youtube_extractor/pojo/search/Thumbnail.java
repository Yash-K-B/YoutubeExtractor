package com.yash.youtube_extractor.pojo.search;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Thumbnail{

	@SerializedName("thumbnails")
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