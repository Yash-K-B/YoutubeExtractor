package com.yash.youtube_extractor.pojo.search;

import com.squareup.moshi.Json;

public class ToggledServiceEndpoint{

	@Json(name="commandMetadata")
	private CommandMetadata commandMetadata;

	@Json(name="playlistEditEndpoint")
	private PlaylistEditEndpoint playlistEditEndpoint;

	@Json(name="clickTrackingParams")
	private String clickTrackingParams;

	public void setCommandMetadata(CommandMetadata commandMetadata){
		this.commandMetadata = commandMetadata;
	}

	public CommandMetadata getCommandMetadata(){
		return commandMetadata;
	}

	public void setPlaylistEditEndpoint(PlaylistEditEndpoint playlistEditEndpoint){
		this.playlistEditEndpoint = playlistEditEndpoint;
	}

	public PlaylistEditEndpoint getPlaylistEditEndpoint(){
		return playlistEditEndpoint;
	}

	public void setClickTrackingParams(String clickTrackingParams){
		this.clickTrackingParams = clickTrackingParams;
	}

	public String getClickTrackingParams(){
		return clickTrackingParams;
	}

	@Override
 	public String toString(){
		return 
			"ToggledServiceEndpoint{" + 
			"commandMetadata = '" + commandMetadata + '\'' + 
			",playlistEditEndpoint = '" + playlistEditEndpoint + '\'' + 
			",clickTrackingParams = '" + clickTrackingParams + '\'' + 
			"}";
		}
}