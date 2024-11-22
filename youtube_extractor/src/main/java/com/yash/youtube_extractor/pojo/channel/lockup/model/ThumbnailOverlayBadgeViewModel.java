package com.yash.youtube_extractor.pojo.channel.lockup.model;

import java.util.List;
import lombok.Data;

@Data
public class ThumbnailOverlayBadgeViewModel{
	private List<ThumbnailBadgesItem> thumbnailBadges;
	private String position;
}