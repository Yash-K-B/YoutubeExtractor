package com.yash.youtube_extractor.pojo.playlist;

import com.squareup.moshi.Json;

import lombok.Data;

@Data
public class ContinuationItemRenderer{

	@Json(name = "continuationEndpoint")
	private ContinuationEndpoint continuationEndpoint;

	@Json(name = "trigger")
	private String trigger;
}