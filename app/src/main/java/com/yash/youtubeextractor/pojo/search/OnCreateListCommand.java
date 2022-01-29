package com.yash.youtubeextractor.pojo.search;

import lombok.Data;

@Data
public class OnCreateListCommand{
	private CommandMetadata commandMetadata;
	private CreatePlaylistServiceEndpoint createPlaylistServiceEndpoint;
	private String clickTrackingParams;
}