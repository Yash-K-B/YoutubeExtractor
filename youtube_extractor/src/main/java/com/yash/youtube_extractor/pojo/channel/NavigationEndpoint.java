package com.yash.youtube_extractor.pojo.channel;

import com.squareup.moshi.Json;

public class NavigationEndpoint{

	@Json(name = "commandMetadata")
	private CommandMetadata commandMetadata;

	@Json(name = "clickTrackingParams")
	private String clickTrackingParams;

	@Json(name = "browseEndpoint")
	private BrowseEndpoint browseEndpoint;

	@Json(name = "watchEndpoint")
	private WatchEndpoint watchEndpoint;

	@Json(name = "watchPlaylistEndpoint")
	private WatchPlaylistEndpoint watchPlaylistEndpoint;

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

	public void setWatchEndpoint(WatchEndpoint watchEndpoint){
		this.watchEndpoint = watchEndpoint;
	}

	public WatchEndpoint getWatchEndpoint(){
		return watchEndpoint;
	}

	public WatchPlaylistEndpoint getWatchPlaylistEndpoint() {
		return watchPlaylistEndpoint;
	}

	public void setWatchPlaylistEndpoint(WatchPlaylistEndpoint watchPlaylistEndpoint) {
		this.watchPlaylistEndpoint = watchPlaylistEndpoint;
	}

	@Override
	public String toString() {
		return "NavigationEndpoint{" +
				"commandMetadata=" + commandMetadata +
				", clickTrackingParams='" + clickTrackingParams + '\'' +
				", browseEndpoint=" + browseEndpoint +
				", watchEndpoint=" + watchEndpoint +
				", watchPlaylistEndpoint=" + watchPlaylistEndpoint +
				'}';
	}
}