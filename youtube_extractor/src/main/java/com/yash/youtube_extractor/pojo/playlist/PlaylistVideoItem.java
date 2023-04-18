package com.yash.youtube_extractor.pojo.playlist;

import com.squareup.moshi.Json;

import lombok.Data;

@Data
public class PlaylistVideoItem{

	@Json(name="playlistVideoRenderer")
	private PlaylistVideoRenderer playlistVideoRenderer;

	@Json(name = "continuationItemRenderer")
	private ContinuationItemRenderer continuationItemRenderer;
}