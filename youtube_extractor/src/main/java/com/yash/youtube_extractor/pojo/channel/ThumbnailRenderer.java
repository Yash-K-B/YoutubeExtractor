package com.yash.youtube_extractor.pojo.channel;

import com.squareup.moshi.Json;

public class ThumbnailRenderer{

	@Json(name = "playlistVideoThumbnailRenderer")
	private PlaylistVideoThumbnailRenderer playlistVideoThumbnailRenderer;

	public void setPlaylistVideoThumbnailRenderer(PlaylistVideoThumbnailRenderer playlistVideoThumbnailRenderer){
		this.playlistVideoThumbnailRenderer = playlistVideoThumbnailRenderer;
	}

	public PlaylistVideoThumbnailRenderer getPlaylistVideoThumbnailRenderer(){
		return playlistVideoThumbnailRenderer;
	}

	@Override
 	public String toString(){
		return 
			"ThumbnailRenderer{" + 
			"playlistVideoThumbnailRenderer = '" + playlistVideoThumbnailRenderer + '\'' + 
			"}";
		}
}