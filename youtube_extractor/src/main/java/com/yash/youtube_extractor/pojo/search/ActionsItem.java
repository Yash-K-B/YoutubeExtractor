package com.yash.youtube_extractor.pojo.search;

import com.google.gson.annotations.SerializedName;

public class ActionsItem{

	@SerializedName("clickTrackingParams")
	private String clickTrackingParams;

	@SerializedName("addToPlaylistCommand")
	private AddToPlaylistCommand addToPlaylistCommand;

	@SerializedName("addedVideoId")
	private String addedVideoId;

	@SerializedName("action")
	private String action;

	@SerializedName("removedVideoId")
	private String removedVideoId;

	public void setClickTrackingParams(String clickTrackingParams){
		this.clickTrackingParams = clickTrackingParams;
	}

	public String getClickTrackingParams(){
		return clickTrackingParams;
	}

	public void setAddToPlaylistCommand(AddToPlaylistCommand addToPlaylistCommand){
		this.addToPlaylistCommand = addToPlaylistCommand;
	}

	public AddToPlaylistCommand getAddToPlaylistCommand(){
		return addToPlaylistCommand;
	}

	public void setAddedVideoId(String addedVideoId){
		this.addedVideoId = addedVideoId;
	}

	public String getAddedVideoId(){
		return addedVideoId;
	}

	public void setAction(String action){
		this.action = action;
	}

	public String getAction(){
		return action;
	}

	public void setRemovedVideoId(String removedVideoId){
		this.removedVideoId = removedVideoId;
	}

	public String getRemovedVideoId(){
		return removedVideoId;
	}

	@Override
 	public String toString(){
		return 
			"ActionsItem{" + 
			"clickTrackingParams = '" + clickTrackingParams + '\'' + 
			",addToPlaylistCommand = '" + addToPlaylistCommand + '\'' + 
			",addedVideoId = '" + addedVideoId + '\'' + 
			",action = '" + action + '\'' + 
			",removedVideoId = '" + removedVideoId + '\'' + 
			"}";
		}
}