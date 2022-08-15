package com.yash.youtube_extractor.pojo.search;

import com.squareup.moshi.Json;

public class RichThumbnail{

	@Json(name="movingThumbnailRenderer")
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