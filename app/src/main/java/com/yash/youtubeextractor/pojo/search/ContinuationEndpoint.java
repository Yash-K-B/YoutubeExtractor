package com.yash.youtubeextractor.pojo.search;

import lombok.Data;

@Data
public class ContinuationEndpoint{
	private CommandMetadata commandMetadata;
	private String clickTrackingParams;
	private ContinuationCommand continuationCommand;
}