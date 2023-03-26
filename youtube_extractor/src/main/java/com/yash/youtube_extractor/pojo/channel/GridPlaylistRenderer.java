package com.yash.youtube_extractor.pojo.channel;

import java.util.List;
import com.squareup.moshi.Json;
import com.yash.youtube_extractor.pojo.common.Thumbnail;

public class GridPlaylistRenderer{

	@Json(name = "playlistId")
	private String playlistId;

	@Json(name = "thumbnail")
	private Thumbnail thumbnail;

	@Json(name = "videoCountShortText")
	private VideoCountShortText videoCountShortText;

	@Json(name = "viewPlaylistText")
	private ViewPlaylistText viewPlaylistText;

	@Json(name = "title")
	private Title title;

	@Json(name = "shortBylineText")
	private ShortBylineText shortBylineText;

	@Json(name = "thumbnailOverlays")
	private List<ThumbnailOverlaysItem> thumbnailOverlays;

	@Json(name = "longBylineText")
	private LongBylineText longBylineText;

	@Json(name = "videoCountText")
	private VideoCountText videoCountText;

	@Json(name = "trackingParams")
	private String trackingParams;

	@Json(name = "thumbnailText")
	private ThumbnailText thumbnailText;

	@Json(name = "publishedTimeText")
	private PublishedTimeText publishedTimeText;

	@Json(name = "sidebarThumbnails")
	private List<SidebarThumbnailsItem> sidebarThumbnails;

	@Json(name = "navigationEndpoint")
	private NavigationEndpoint navigationEndpoint;

	@Json(name = "thumbnailRenderer")
	private ThumbnailRenderer thumbnailRenderer;

	public void setPlaylistId(String playlistId){
		this.playlistId = playlistId;
	}

	public String getPlaylistId(){
		return playlistId;
	}

	public void setThumbnail(Thumbnail thumbnail){
		this.thumbnail = thumbnail;
	}

	public Thumbnail getThumbnail(){
		return thumbnail;
	}

	public void setVideoCountShortText(VideoCountShortText videoCountShortText){
		this.videoCountShortText = videoCountShortText;
	}

	public VideoCountShortText getVideoCountShortText(){
		return videoCountShortText;
	}

	public void setViewPlaylistText(ViewPlaylistText viewPlaylistText){
		this.viewPlaylistText = viewPlaylistText;
	}

	public ViewPlaylistText getViewPlaylistText(){
		return viewPlaylistText;
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

	public void setThumbnailOverlays(List<ThumbnailOverlaysItem> thumbnailOverlays){
		this.thumbnailOverlays = thumbnailOverlays;
	}

	public List<ThumbnailOverlaysItem> getThumbnailOverlays(){
		return thumbnailOverlays;
	}

	public void setLongBylineText(LongBylineText longBylineText){
		this.longBylineText = longBylineText;
	}

	public LongBylineText getLongBylineText(){
		return longBylineText;
	}

	public void setVideoCountText(VideoCountText videoCountText){
		this.videoCountText = videoCountText;
	}

	public VideoCountText getVideoCountText(){
		return videoCountText;
	}

	public void setTrackingParams(String trackingParams){
		this.trackingParams = trackingParams;
	}

	public String getTrackingParams(){
		return trackingParams;
	}

	public void setThumbnailText(ThumbnailText thumbnailText){
		this.thumbnailText = thumbnailText;
	}

	public ThumbnailText getThumbnailText(){
		return thumbnailText;
	}

	public void setPublishedTimeText(PublishedTimeText publishedTimeText){
		this.publishedTimeText = publishedTimeText;
	}

	public PublishedTimeText getPublishedTimeText(){
		return publishedTimeText;
	}

	public void setSidebarThumbnails(List<SidebarThumbnailsItem> sidebarThumbnails){
		this.sidebarThumbnails = sidebarThumbnails;
	}

	public List<SidebarThumbnailsItem> getSidebarThumbnails(){
		return sidebarThumbnails;
	}

	public void setNavigationEndpoint(NavigationEndpoint navigationEndpoint){
		this.navigationEndpoint = navigationEndpoint;
	}

	public NavigationEndpoint getNavigationEndpoint(){
		return navigationEndpoint;
	}

	public void setThumbnailRenderer(ThumbnailRenderer thumbnailRenderer){
		this.thumbnailRenderer = thumbnailRenderer;
	}

	public ThumbnailRenderer getThumbnailRenderer(){
		return thumbnailRenderer;
	}

	@Override
 	public String toString(){
		return 
			"GridPlaylistRenderer{" + 
			"playlistId = '" + playlistId + '\'' + 
			",thumbnail = '" + thumbnail + '\'' + 
			",videoCountShortText = '" + videoCountShortText + '\'' + 
			",viewPlaylistText = '" + viewPlaylistText + '\'' + 
			",title = '" + title + '\'' + 
			",shortBylineText = '" + shortBylineText + '\'' + 
			",thumbnailOverlays = '" + thumbnailOverlays + '\'' + 
			",longBylineText = '" + longBylineText + '\'' + 
			",videoCountText = '" + videoCountText + '\'' + 
			",trackingParams = '" + trackingParams + '\'' + 
			",thumbnailText = '" + thumbnailText + '\'' + 
			",publishedTimeText = '" + publishedTimeText + '\'' + 
			",sidebarThumbnails = '" + sidebarThumbnails + '\'' + 
			",navigationEndpoint = '" + navigationEndpoint + '\'' + 
			",thumbnailRenderer = '" + thumbnailRenderer + '\'' + 
			"}";
		}
}