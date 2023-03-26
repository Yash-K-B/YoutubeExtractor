package com.yash.youtube_extractor.pojo.channel;

import com.squareup.moshi.Json;

public class WatchEndpoint{

	@Json(name = "playlistId")
	private String playlistId;

	@Json(name = "watchEndpointSupportedOnesieConfig")
	private WatchEndpointSupportedOnesieConfig watchEndpointSupportedOnesieConfig;

	@Json(name = "continuePlayback")
	private Boolean continuePlayback;

	@Json(name = "videoId")
	private String videoId;

	@Json(name = "params")
	private String params;

	@Json(name = "loggingContext")
	private LoggingContext loggingContext;

	public void setPlaylistId(String playlistId){
		this.playlistId = playlistId;
	}

	public String getPlaylistId(){
		return playlistId;
	}

	public void setWatchEndpointSupportedOnesieConfig(WatchEndpointSupportedOnesieConfig watchEndpointSupportedOnesieConfig){
		this.watchEndpointSupportedOnesieConfig = watchEndpointSupportedOnesieConfig;
	}

	public WatchEndpointSupportedOnesieConfig getWatchEndpointSupportedOnesieConfig(){
		return watchEndpointSupportedOnesieConfig;
	}

	public void setContinuePlayback(Boolean continuePlayback){
		this.continuePlayback = continuePlayback;
	}

	public Boolean isContinuePlayback(){
		return continuePlayback;
	}

	public void setVideoId(String videoId){
		this.videoId = videoId;
	}

	public String getVideoId(){
		return videoId;
	}

	public void setParams(String params){
		this.params = params;
	}

	public String getParams(){
		return params;
	}

	public void setLoggingContext(LoggingContext loggingContext){
		this.loggingContext = loggingContext;
	}

	public LoggingContext getLoggingContext(){
		return loggingContext;
	}

	@Override
 	public String toString(){
		return 
			"WatchEndpoint{" + 
			"playlistId = '" + playlistId + '\'' + 
			",watchEndpointSupportedOnesieConfig = '" + watchEndpointSupportedOnesieConfig + '\'' + 
			",continuePlayback = '" + continuePlayback + '\'' + 
			",videoId = '" + videoId + '\'' + 
			",params = '" + params + '\'' + 
			",loggingContext = '" + loggingContext + '\'' + 
			"}";
		}
}