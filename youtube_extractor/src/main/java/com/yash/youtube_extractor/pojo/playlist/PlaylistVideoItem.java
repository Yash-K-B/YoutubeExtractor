package com.yash.youtube_extractor.pojo.playlist;

import com.squareup.moshi.Json;

public class PlaylistVideoItem{

	@Json(name="playlistVideoRenderer")
	private PlaylistVideoRenderer playlistVideoRenderer;

	public void setPlaylistVideoRenderer(PlaylistVideoRenderer playlistVideoRenderer){
		this.playlistVideoRenderer = playlistVideoRenderer;
	}

	public PlaylistVideoRenderer getPlaylistVideoRenderer(){
		return playlistVideoRenderer;
	}

	@Override
 	public String toString(){
		return 
			"PlaylistVideoItem{" + 
			"playlistVideoRenderer = '" + playlistVideoRenderer + '\'' + 
			"}";
		}
}