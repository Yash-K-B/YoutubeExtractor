package com.yash.youtube_extractor.pojo.search;

import java.util.List;
import com.squareup.moshi.Json;
import com.yash.youtube_extractor.pojo.common.ThumbnailsItem;

public class MovingThumbnailDetails{

	@Json(name="logAsMovingThumbnail")
	private Boolean logAsMovingThumbnail;

	@Json(name="thumbnails")
	private List<ThumbnailsItem> thumbnails;

	public void setLogAsMovingThumbnail(Boolean logAsMovingThumbnail){
		this.logAsMovingThumbnail = logAsMovingThumbnail;
	}

	public Boolean isLogAsMovingThumbnail(){
		return logAsMovingThumbnail;
	}

	public void setThumbnails(List<ThumbnailsItem> thumbnails){
		this.thumbnails = thumbnails;
	}

	public List<ThumbnailsItem> getThumbnails(){
		return thumbnails;
	}

	@Override
 	public String toString(){
		return 
			"MovingThumbnailDetails{" + 
			"logAsMovingThumbnail = '" + logAsMovingThumbnail + '\'' + 
			",thumbnails = '" + thumbnails + '\'' + 
			"}";
		}
}