package com.yash.youtube_extractor.pojo.playlist;

import java.util.List;
import com.squareup.moshi.Json;
import com.yash.youtube_extractor.pojo.common.LengthText;
import com.yash.youtube_extractor.pojo.common.Thumbnail;

public class PlaylistVideoRenderer{

	@Json(name="lengthText")
	private LengthText lengthText;

	@Json(name="isPlayable")
	private Boolean isPlayable;

	@Json(name="thumbnail")
	private Thumbnail thumbnail;

	@Json(name="trackingParams")
	private String trackingParams;

	@Json(name="lengthSeconds")
	private String lengthSeconds;

	@Json(name="videoId")
	private String videoId;

	@Json(name="title")
	private Title title;

	@Json(name="shortBylineText")
	private ShortBylineText shortBylineText;

	@Json(name="menu")
	private Menu menu;

	@Json(name="thumbnailOverlays")
	private List<ThumbnailOverlaysItem> thumbnailOverlays;

	@Json(name="navigationEndpoint")
	private NavigationEndpoint navigationEndpoint;

	public void setLengthText(LengthText lengthText){
		this.lengthText = lengthText;
	}

	public LengthText getLengthText(){
		return lengthText;
	}

	public void setIsPlayable(Boolean isPlayable){
		this.isPlayable = isPlayable;
	}

	public Boolean isIsPlayable(){
		return isPlayable;
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

	public void setLengthSeconds(String lengthSeconds){
		this.lengthSeconds = lengthSeconds;
	}

	public String getLengthSeconds(){
		return lengthSeconds;
	}

	public void setVideoId(String videoId){
		this.videoId = videoId;
	}

	public String getVideoId(){
		return videoId;
	}

	public void setTitle(Title title){
		this.title = title;
	}

	public Title getTitle(){
		return title;
	}

	public void setShortBylineText(ShortBylineText shortBylineText){
		this.shortBylineText = shortBylineText;
	}

	public ShortBylineText getShortBylineText(){
		return shortBylineText;
	}

	public void setMenu(Menu menu){
		this.menu = menu;
	}

	public Menu getMenu(){
		return menu;
	}

	public void setThumbnailOverlays(List<ThumbnailOverlaysItem> thumbnailOverlays){
		this.thumbnailOverlays = thumbnailOverlays;
	}

	public List<ThumbnailOverlaysItem> getThumbnailOverlays(){
		return thumbnailOverlays;
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
			"PlaylistVideoRenderer{" + 
			"lengthText = '" + lengthText + '\'' + 
			",isPlayable = '" + isPlayable + '\'' + 
			",thumbnail = '" + thumbnail + '\'' + 
			",trackingParams = '" + trackingParams + '\'' + 
			",lengthSeconds = '" + lengthSeconds + '\'' + 
			",videoId = '" + videoId + '\'' + 
			",title = '" + title + '\'' + 
			",shortBylineText = '" + shortBylineText + '\'' + 
			",menu = '" + menu + '\'' + 
			",thumbnailOverlays = '" + thumbnailOverlays + '\'' + 
			",navigationEndpoint = '" + navigationEndpoint + '\'' + 
			"}";
		}
}