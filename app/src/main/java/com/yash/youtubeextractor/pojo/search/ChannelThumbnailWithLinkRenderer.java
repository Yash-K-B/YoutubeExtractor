package com.yash.youtubeextractor.pojo.search;

import lombok.Data;

@Data
public class ChannelThumbnailWithLinkRenderer{
	private Thumbnail thumbnail;
	private Accessibility accessibility;
	private NavigationEndpoint navigationEndpoint;
}