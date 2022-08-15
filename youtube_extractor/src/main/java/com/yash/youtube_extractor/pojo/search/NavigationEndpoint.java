package com.yash.youtube_extractor.pojo.search;

import com.squareup.moshi.Json;

public class NavigationEndpoint{

	@Json(name="commandMetadata")
	private CommandMetadata commandMetadata;

	@Json(name="clickTrackingParams")
	private String clickTrackingParams;

	@Json(name="watchEndpoint")
	private WatchEndpoint watchEndpoint;

	@Json(name="browseEndpoint")
	private BrowseEndpoint browseEndpoint;

	public void setCommandMetadata(CommandMetadata commandMetadata){
		this.commandMetadata = commandMetadata;
	}

	public CommandMetadata getCommandMetadata(){
		return commandMetadata;
	}

	public void setClickTrackingParams(String clickTrackingParams){
		this.clickTrackingParams = clickTrackingParams;
	}

	public String getClickTrackingParams(){
		return clickTrackingParams;
	}

	public void setWatchEndpoint(WatchEndpoint watchEndpoint){
		this.watchEndpoint = watchEndpoint;
	}

	public WatchEndpoint getWatchEndpoint(){
		return watchEndpoint;
	}

	public void setBrowseEndpoint(BrowseEndpoint browseEndpoint){
		this.browseEndpoint = browseEndpoint;
	}

	public BrowseEndpoint getBrowseEndpoint(){
		return browseEndpoint;
	}

	@Override
 	public String toString(){
		return 
			"NavigationEndpoint{" + 
			"commandMetadata = '" + commandMetadata + '\'' + 
			",clickTrackingParams = '" + clickTrackingParams + '\'' + 
			",watchEndpoint = '" + watchEndpoint + '\'' + 
			",browseEndpoint = '" + browseEndpoint + '\'' + 
			"}";
		}
}