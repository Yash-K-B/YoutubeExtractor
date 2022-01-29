package com.yash.youtubeextractor.pojo.search;

import lombok.Data;

@Data
public class NavigationEndpoint{
	private CommandMetadata commandMetadata;
	private String clickTrackingParams;
	private WatchEndpoint watchEndpoint;
	private BrowseEndpoint browseEndpoint;
}