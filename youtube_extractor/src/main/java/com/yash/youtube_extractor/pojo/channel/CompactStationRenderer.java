package com.yash.youtube_extractor.pojo.channel;

import com.squareup.moshi.Json;
import com.yash.youtube_extractor.pojo.common.Thumbnail;

public class CompactStationRenderer{

	@Json(name = "videoCountText")
	private VideoCountText videoCountText;

	@Json(name = "thumbnail")
	private Thumbnail thumbnail;

	@Json(name = "trackingParams")
	private String trackingParams;

	@Json(name = "description")
	private Description description;

	@Json(name = "title")
	private Title title;

	@Json(name = "navigationEndpoint")
	private NavigationEndpoint navigationEndpoint;

	public void setVideoCountText(VideoCountText videoCountText){
		this.videoCountText = videoCountText;
	}

	public VideoCountText getVideoCountText(){
		return videoCountText;
	}

	public void setThumbnail(Thumbnail thumbnail){
		this.thumbnail = thumbnail;
	}

	public Thumbnail getThumbnail(){
		return thumbnail;
	}

	public void setTrackingParams(String trackingParams){
		this.trackingParams = trackingParams;
	}

	public String getTrackingParams(){
		return trackingParams;
	}

	public void setDescription(Description description){
		this.description = description;
	}

	public Description getDescription(){
		return description;
	}

	public void setTitle(Title title){
		this.title = title;
	}

	public Title getTitle(){
		return title;
	}

	public void setNavigationEndpoint(NavigationEndpoint navigationEndpoint){
		this.navigationEndpoint = navigationEndpoint;
	}

	public NavigationEndpoint getNavigationEndpoint(){
		return navigationEndpoint;
	}

	@Override
 	public String toString(){
		return 
			"CompactStationRenderer{" + 
			"videoCountText = '" + videoCountText + '\'' + 
			",thumbnail = '" + thumbnail + '\'' + 
			",trackingParams = '" + trackingParams + '\'' + 
			",description = '" + description + '\'' + 
			",title = '" + title + '\'' + 
			",navigationEndpoint = '" + navigationEndpoint + '\'' + 
			"}";
		}
}