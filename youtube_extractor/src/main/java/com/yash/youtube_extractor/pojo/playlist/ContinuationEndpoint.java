package com.yash.youtube_extractor.pojo.playlist;

import com.squareup.moshi.Json;

import lombok.Data;

@Data
public class ContinuationEndpoint{

	@Json(name = "commandMetadata")
	private CommandMetadata commandMetadata;

	@Json(name = "clickTrackingParams")
	private String clickTrackingParams;

	@Json(name = "continuationCommand")
	private ContinuationCommand continuationCommand;
}