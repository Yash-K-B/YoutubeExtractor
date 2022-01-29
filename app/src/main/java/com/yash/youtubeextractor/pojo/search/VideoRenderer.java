package com.yash.youtubeextractor.pojo.search;

import java.util.List;
import lombok.Data;

@Data
public class VideoRenderer{
	private LengthText lengthText;
	private Thumbnail thumbnail;
	private List<DetailedMetadataSnippetsItem> detailedMetadataSnippets;
	private String videoId;
	private Title title;
	private ShortBylineText shortBylineText;
	private Menu menu;
	private List<ThumbnailOverlaysItem> thumbnailOverlays;
	private OwnerText ownerText;
	private RichThumbnail richThumbnail;
	private LongBylineText longBylineText;
	private String trackingParams;
	private Boolean showActionMenu;
	private PublishedTimeText publishedTimeText;
	private ViewCountText viewCountText;
	private ShortViewCountText shortViewCountText;
	private ChannelThumbnailSupportedRenderers channelThumbnailSupportedRenderers;
	private NavigationEndpoint navigationEndpoint;
	private List<OwnerBadgesItem> ownerBadges;
	private List<BadgesItem> badges;
}