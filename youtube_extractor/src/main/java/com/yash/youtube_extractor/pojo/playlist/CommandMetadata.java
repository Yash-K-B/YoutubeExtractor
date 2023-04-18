package com.yash.youtube_extractor.pojo.playlist;

import com.squareup.moshi.Json;

import lombok.Data;

@Data
public class CommandMetadata{

	@Json(name = "webCommandMetadata")
	private WebCommandMetadata webCommandMetadata;
}