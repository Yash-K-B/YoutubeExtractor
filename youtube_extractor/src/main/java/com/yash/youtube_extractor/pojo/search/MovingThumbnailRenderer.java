package com.yash.youtube_extractor.pojo.search;

import com.google.gson.annotations.SerializedName;

public class MovingThumbnailRenderer{

	@SerializedName("enableOverlay")
	private Boolean enableOverlay;

	@SerializedName("enableHoveredLogging")
	private Boolean enableHoveredLogging;

	@SerializedName("movingThumbnailDetails")
	private MovingThumbnailDetails movingThumbnailDetails;

	public void setEnableOverlay(Boolean enableOverlay){
		this.enableOverlay = enableOverlay;
	}

	public Boolean isEnableOverlay(){
		return enableOverlay;
	}

	public void setEnableHoveredLogging(Boolean enableHoveredLogging){
		this.enableHoveredLogging = enableHoveredLogging;
	}

	public Boolean isEnableHoveredLogging(){
		return enableHoveredLogging;
	}

	public void setMovingThumbnailDetails(MovingThumbnailDetails movingThumbnailDetails){
		this.movingThumbnailDetails = movingThumbnailDetails;
	}

	public MovingThumbnailDetails getMovingThumbnailDetails(){
		return movingThumbnailDetails;
	}

	@Override
 	public String toString(){
		return 
			"MovingThumbnailRenderer{" + 
			"enableOverlay = '" + enableOverlay + '\'' + 
			",enableHoveredLogging = '" + enableHoveredLogging + '\'' + 
			",movingThumbnailDetails = '" + movingThumbnailDetails + '\'' + 
			"}";
		}
}