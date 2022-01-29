package com.yash.youtube_extractor.pojo.search;

import com.google.gson.annotations.SerializedName;

public class WatchEndpoint{

	@SerializedName("watchEndpointSupportedOnesieConfig")
	private WatchEndpointSupportedOnesieConfig watchEndpointSupportedOnesieConfig;

	@SerializedName("videoId")
	private String videoId;

	@SerializedName("params")
	private String params;

	public void setWatchEndpointSupportedOnesieConfig(WatchEndpointSupportedOnesieConfig watchEndpointSupportedOnesieConfig){
		this.watchEndpointSupportedOnesieConfig = watchEndpointSupportedOnesieConfig;
	}

	public WatchEndpointSupportedOnesieConfig getWatchEndpointSupportedOnesieConfig(){
		return watchEndpointSupportedOnesieConfig;
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

	@Override
 	public String toString(){
		return 
			"WatchEndpoint{" + 
			"watchEndpointSupportedOnesieConfig = '" + watchEndpointSupportedOnesieConfig + '\'' + 
			",videoId = '" + videoId + '\'' + 
			",params = '" + params + '\'' + 
			"}";
		}
}