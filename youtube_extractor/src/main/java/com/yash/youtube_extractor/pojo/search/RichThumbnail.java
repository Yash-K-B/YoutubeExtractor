package com.yash.youtube_extractor.pojo.search;

import com.google.gson.annotations.SerializedName;

public class RichThumbnail{

	@SerializedName("movingThumbnailRenderer")
	private MovingThumbnailRenderer movingThumbnailRenderer;

	public void setMovingThumbnailRenderer(MovingThumbnailRenderer movingThumbnailRenderer){
		this.movingThumbnailRenderer = movingThumbnailRenderer;
	}

	public MovingThumbnailRenderer getMovingThumbnailRenderer(){
		return movingThumbnailRenderer;
	}

	@Override
 	public String toString(){
		return 
			"RichThumbnail{" + 
			"movingThumbnailRenderer = '" + movingThumbnailRenderer + '\'' + 
			"}";
		}
}