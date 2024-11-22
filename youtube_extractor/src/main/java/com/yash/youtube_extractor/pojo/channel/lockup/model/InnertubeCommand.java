package com.yash.youtube_extractor.pojo.channel.lockup.model;

import lombok.Data;

@Data
public class InnertubeCommand{
	private CommandMetadata commandMetadata;
	private String clickTrackingParams;
	private WatchPlaylistEndpoint watchPlaylistEndpoint;
}