package com.yash.youtube_extractor.pojo.playlist;

import com.squareup.moshi.Json;

import lombok.Data;

@Data
public class ContinuationCommand{

	@Json(name = "request")
	private String request;

	@Json(name = "token")
	private String token;
}