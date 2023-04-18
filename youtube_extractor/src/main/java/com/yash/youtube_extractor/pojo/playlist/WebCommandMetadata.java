package com.yash.youtube_extractor.pojo.playlist;

import com.squareup.moshi.Json;

import lombok.Data;

@Data
public class WebCommandMetadata{

	@Json(name="rootVe")
	private Integer rootVe;

	@Json(name="webPageType")
	private String webPageType;

	@Json(name="url")
	private String url;

	@Json(name="apiUrl")
	private String apiUrl;

	@Json(name="sendPost")
	private Boolean sendPost;
}