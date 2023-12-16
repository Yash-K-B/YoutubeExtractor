package com.yash.youtube_extractor.pojo.channel;

import com.squareup.moshi.Json;

public class WatchPlaylistEndpoint {

	@Json(name = "playlistId")
	private String playlistId;

	public void setPlaylistId(String playlistId){
		this.playlistId = playlistId;
	}

	public String getPlaylistId(){
		return playlistId;
	}

	@Override
	public String toString() {
		return "WatchPlaylistEndpoint{" +
				"playlistId='" + playlistId + '\'' +
				'}';
	}
}