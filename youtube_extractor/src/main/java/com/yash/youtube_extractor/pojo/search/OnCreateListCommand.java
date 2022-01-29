package com.yash.youtube_extractor.pojo.search;

import com.google.gson.annotations.SerializedName;

public class OnCreateListCommand{

	@SerializedName("commandMetadata")
	private CommandMetadata commandMetadata;

	@SerializedName("createPlaylistServiceEndpoint")
	private CreatePlaylistServiceEndpoint createPlaylistServiceEndpoint;

	@SerializedName("clickTrackingParams")
	private String clickTrackingParams;

	public void setCommandMetadata(CommandMetadata commandMetadata){
		this.commandMetadata = commandMetadata;
	}

	public CommandMetadata getCommandMetadata(){
		return commandMetadata;
	}

	public void setCreatePlaylistServiceEndpoint(CreatePlaylistServiceEndpoint createPlaylistServiceEndpoint){
		this.createPlaylistServiceEndpoint = createPlaylistServiceEndpoint;
	}

	public CreatePlaylistServiceEndpoint getCreatePlaylistServiceEndpoint(){
		return createPlaylistServiceEndpoint;
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
			"OnCreateListCommand{" + 
			"commandMetadata = '" + commandMetadata + '\'' + 
			",createPlaylistServiceEndpoint = '" + createPlaylistServiceEndpoint + '\'' + 
			",clickTrackingParams = '" + clickTrackingParams + '\'' + 
			"}";
		}
}