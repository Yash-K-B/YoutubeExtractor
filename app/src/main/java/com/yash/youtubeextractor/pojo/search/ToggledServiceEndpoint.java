package com.yash.youtubeextractor.pojo.search;

import lombok.Data;

@Data
public class ToggledServiceEndpoint{
	private CommandMetadata commandMetadata;
	private PlaylistEditEndpoint playlistEditEndpoint;
	private String clickTrackingParams;
}