package com.yash.youtube_extractor.pojo.search;

import java.util.List;
import com.squareup.moshi.Json;
import com.yash.youtube_extractor.pojo.common.LengthText;
import com.yash.youtube_extractor.pojo.common.Thumbnail;

public class VideoRenderer{

	@Json(name="lengthText")
	private LengthText lengthText;

	@Json(name="thumbnail")
	private Thumbnail thumbnail;

	@Json(name="detailedMetadataSnippets")
	private List<DetailedMetadataSnippetsItem> detailedMetadataSnippets;

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

	@Json(name="ownerText")
	private OwnerText ownerText;

	@Json(name="richThumbnail")
	private RichThumbnail richThumbnail;

	@Json(name="longBylineText")
	private LongBylineText longBylineText;

	@Json(name="trackingParams")
	private String trackingParams;

	@Json(name="showActionMenu")
	private Boolean showActionMenu;

	@Json(name="publishedTimeText")
	private PublishedTimeText publishedTimeText;

	@Json(name="viewCountText")
	private ViewCountText viewCountText;

	@Json(name="shortViewCountText")
	private ShortViewCountText shortViewCountText;

	@Json(name="channelThumbnailSupportedRenderers")
	private ChannelThumbnailSupportedRenderers channelThumbnailSupportedRenderers;

	@Json(name="navigationEndpoint")
	private NavigationEndpoint navigationEndpoint;

	@Json(name="ownerBadges")
	private List<OwnerBadgesItem> ownerBadges;

	@Json(name="badges")
	private List<BadgesItem> badges;

	public void setLengthText(LengthText lengthText){
		this.lengthText = lengthText;
	}

	public LengthText getLengthText(){
		return lengthText;
	}

	public void setThumbnail(Thumbnail thumbnail){
		this.thumbnail = thumbnail;
	}

	public Thumbnail getThumbnail(){
		return thumbnail;
	}

	public void setDetailedMetadataSnippets(List<DetailedMetadataSnippetsItem> detailedMetadataSnippets){
		this.detailedMetadataSnippets = detailedMetadataSnippets;
	}

	public List<DetailedMetadataSnippetsItem> getDetailedMetadataSnippets(){
		return detailedMetadataSnippets;
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

	public void setOwnerText(OwnerText ownerText){
		this.ownerText = ownerText;
	}

	public OwnerText getOwnerText(){
		return ownerText;
	}

	public void setRichThumbnail(RichThumbnail richThumbnail){
		this.richThumbnail = richThumbnail;
	}

	public RichThumbnail getRichThumbnail(){
		return richThumbnail;
	}

	public void setLongBylineText(LongBylineText longBylineText){
		this.longBylineText = longBylineText;
	}

	public LongBylineText getLongBylineText(){
		return longBylineText;
	}

	public void setTrackingParams(String trackingParams){
		this.trackingParams = trackingParams;
	}

	public String getTrackingParams(){
		return trackingParams;
	}

	public void setShowActionMenu(Boolean showActionMenu){
		this.showActionMenu = showActionMenu;
	}

	public Boolean isShowActionMenu(){
		return showActionMenu;
	}

	public void setPublishedTimeText(PublishedTimeText publishedTimeText){
		this.publishedTimeText = publishedTimeText;
	}

	public PublishedTimeText getPublishedTimeText(){
		return publishedTimeText;
	}

	public void setViewCountText(ViewCountText viewCountText){
		this.viewCountText = viewCountText;
	}

	public ViewCountText getViewCountText(){
		return viewCountText;
	}

	public void setShortViewCountText(ShortViewCountText shortViewCountText){
		this.shortViewCountText = shortViewCountText;
	}

	public ShortViewCountText getShortViewCountText(){
		return shortViewCountText;
	}

	public void setChannelThumbnailSupportedRenderers(ChannelThumbnailSupportedRenderers channelThumbnailSupportedRenderers){
		this.channelThumbnailSupportedRenderers = channelThumbnailSupportedRenderers;
	}

	public ChannelThumbnailSupportedRenderers getChannelThumbnailSupportedRenderers(){
		return channelThumbnailSupportedRenderers;
	}

	public void setNavigationEndpoint(NavigationEndpoint navigationEndpoint){
		this.navigationEndpoint = navigationEndpoint;
	}

	public NavigationEndpoint getNavigationEndpoint(){
		return navigationEndpoint;
	}

	public void setOwnerBadges(List<OwnerBadgesItem> ownerBadges){
		this.ownerBadges = ownerBadges;
	}

	public List<OwnerBadgesItem> getOwnerBadges(){
		return ownerBadges;
	}

	public void setBadges(List<BadgesItem> badges){
		this.badges = badges;
	}

	public List<BadgesItem> getBadges(){
		return badges;
	}

	@Override
 	public String toString(){
		return 
			"VideoRenderer{" + 
			"lengthText = '" + lengthText + '\'' + 
			",thumbnail = '" + thumbnail + '\'' + 
			",detailedMetadataSnippets = '" + detailedMetadataSnippets + '\'' + 
			",videoId = '" + videoId + '\'' + 
			",title = '" + title + '\'' + 
			",shortBylineText = '" + shortBylineText + '\'' + 
			",menu = '" + menu + '\'' + 
			",thumbnailOverlays = '" + thumbnailOverlays + '\'' + 
			",ownerText = '" + ownerText + '\'' + 
			",richThumbnail = '" + richThumbnail + '\'' + 
			",longBylineText = '" + longBylineText + '\'' + 
			",trackingParams = '" + trackingParams + '\'' + 
			",showActionMenu = '" + showActionMenu + '\'' + 
			",publishedTimeText = '" + publishedTimeText + '\'' + 
			",viewCountText = '" + viewCountText + '\'' + 
			",shortViewCountText = '" + shortViewCountText + '\'' + 
			",channelThumbnailSupportedRenderers = '" + channelThumbnailSupportedRenderers + '\'' + 
			",navigationEndpoint = '" + navigationEndpoint + '\'' + 
			",ownerBadges = '" + ownerBadges + '\'' + 
			",badges = '" + badges + '\'' + 
			"}";
		}
}