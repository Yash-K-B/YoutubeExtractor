package com.yash.youtube_extractor.pojo.search;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class PlaylistEditEndpoint{

	@SerializedName("playlistId")
	private String playlistId;

	@SerializedName("actions")
	private List<ActionsItem> actions;

	public void setPlaylistId(String playlistId){
		this.playlistId = playlistId;
	}

	public String getPlaylistId(){
		return playlistId;
	}

	public void setActions(List<ActionsItem> actions){
		this.actions = actions;
	}

	public List<ActionsItem> getActions(){
		return actions;
	}

	@Override
 	public String toString(){
		return 
			"PlaylistEditEndpoint{" + 
			"playlistId = '" + playlistId + '\'' + 
			",actions = '" + actions + '\'' + 
			"}";
		}
}