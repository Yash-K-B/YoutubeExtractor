package com.yash.youtube_extractor.pojo.search;

import com.google.gson.annotations.SerializedName;

public class NavigationEndpoint{

	@SerializedName("commandMetadata")
	private CommandMetadata commandMetadata;

	@SerializedName("clickTrackingParams")
	private String clickTrackingParams;

	@SerializedName("watchEndpoint")
	private WatchEndpoint watchEndpoint;

	@SerializedName("browseEndpoint")
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