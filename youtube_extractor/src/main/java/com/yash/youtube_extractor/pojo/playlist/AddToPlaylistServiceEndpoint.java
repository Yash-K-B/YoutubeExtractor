package com.yash.youtube_extractor.pojo.playlist;

import com.squareup.moshi.Json;

public class AddToPlaylistServiceEndpoint{

	@Json(name="videoId")
	private String videoId;

	public void setVideoId(String videoId){
		this.videoId = videoId;
	}

	public String getVideoId(){
		return videoId;
	}

	@Override
 	public String toString(){
		return 
			"AddToPlaylistServiceEndpoint{" + 
			"videoId = '" + videoId + '\'' + 
			"}";
		}
}