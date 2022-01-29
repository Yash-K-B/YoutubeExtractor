package com.yash.youtube_extractor.pojo.search;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class AddToPlaylistCommand{

	@SerializedName("onCreateListCommand")
	private OnCreateListCommand onCreateListCommand;

	@SerializedName("videoId")
	private String videoId;

	@SerializedName("openMiniplayer")
	private Boolean openMiniplayer;

	@SerializedName("listType")
	private String listType;

	@SerializedName("videoIds")
	private List<String> videoIds;

	public void setOnCreateListCommand(OnCreateListCommand onCreateListCommand){
		this.onCreateListCommand = onCreateListCommand;
	}

	public OnCreateListCommand getOnCreateListCommand(){
		return onCreateListCommand;
	}

	public void setVideoId(String videoId){
		this.videoId = videoId;
	}

	public String getVideoId(){
		return videoId;
	}

	public void setOpenMiniplayer(Boolean openMiniplayer){
		this.openMiniplayer = openMiniplayer;
	}

	public Boolean isOpenMiniplayer(){
		return openMiniplayer;
	}

	public void setListType(String listType){
		this.listType = listType;
	}

	public String getListType(){
		return listType;
	}

	public void setVideoIds(List<String> videoIds){
		this.videoIds = videoIds;
	}

	public List<String> getVideoIds(){
		return videoIds;
	}

	@Override
 	public String toString(){
		return 
			"AddToPlaylistCommand{" + 
			"onCreateListCommand = '" + onCreateListCommand + '\'' + 
			",videoId = '" + videoId + '\'' + 
			",openMiniplayer = '" + openMiniplayer + '\'' + 
			",listType = '" + listType + '\'' + 
			",videoIds = '" + videoIds + '\'' + 
			"}";
		}
}