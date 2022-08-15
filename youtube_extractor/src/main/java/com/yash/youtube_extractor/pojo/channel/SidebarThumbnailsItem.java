package com.yash.youtube_extractor.pojo.channel;

import java.util.List;
import com.squareup.moshi.Json;
import com.yash.youtube_extractor.pojo.common.ThumbnailsItem;

public class SidebarThumbnailsItem{

	@Json(name = "thumbnails")
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
			"SidebarThumbnailsItem{" + 
			"thumbnails = '" + thumbnails + '\'' + 
			"}";
		}
}