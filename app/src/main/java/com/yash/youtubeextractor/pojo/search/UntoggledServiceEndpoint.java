package com.yash.youtubeextractor.pojo.search;

import lombok.Data;

@Data
public class UntoggledServiceEndpoint{
	private CommandMetadata commandMetadata;
	private String clickTrackingParams;
	private SignalServiceEndpoint signalServiceEndpoint;
	private PlaylistEditEndpoint playlistEditEndpoint;
}