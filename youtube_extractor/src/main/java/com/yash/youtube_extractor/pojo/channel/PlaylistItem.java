package com.yash.youtube_extractor.pojo.channel;

import com.squareup.moshi.Json;
import com.yash.youtube_extractor.pojo.channel.lockup.model.LockupViewModel;

import lombok.Data;

@Data
public class PlaylistItem {

	@Json(name = "compactStationRenderer")
	private CompactStationRenderer compactStationRenderer;

	@Json(name = "gridPlaylistRenderer")
	private GridPlaylistRenderer gridPlaylistRenderer;

	@Json(name = "lockupViewModel")
	private LockupViewModel lockupViewModel;

}