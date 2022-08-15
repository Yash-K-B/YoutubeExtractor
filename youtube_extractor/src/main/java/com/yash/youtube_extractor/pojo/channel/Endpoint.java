package com.yash.youtube_extractor.pojo.channel;

import com.squareup.moshi.Json;

public class Endpoint{

	@Json(name = "commandMetadata")
	private CommandMetadata commandMetadata;

	@Json(name = "clickTrackingParams")
	private String clickTrackingParams;

	@Json(name = "browseEndpoint")
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

	public void setBrowseEndpoint(BrowseEndpoint browseEndpoint){
		this.browseEndpoint = browseEndpoint;
	}

	public BrowseEndpoint getBrowseEndpoint(){
		return browseEndpoint;
	}

	@Override
 	public String toString(){
		return 
			"Endpoint{" + 
			"commandMetadata = '" + commandMetadata + '\'' + 
			",clickTrackingParams = '" + clickTrackingParams + '\'' + 
			",browseEndpoint = '" + browseEndpoint + '\'' + 
			"}";
		}
}