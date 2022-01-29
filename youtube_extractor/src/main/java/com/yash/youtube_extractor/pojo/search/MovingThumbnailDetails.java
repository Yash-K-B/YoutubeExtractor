package com.yash.youtube_extractor.pojo.search;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class MovingThumbnailDetails{

	@SerializedName("logAsMovingThumbnail")
	private Boolean logAsMovingThumbnail;

	@SerializedName("thumbnails")
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