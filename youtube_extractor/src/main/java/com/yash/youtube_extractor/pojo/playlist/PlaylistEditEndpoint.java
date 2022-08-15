package com.yash.youtube_extractor.pojo.playlist;

import java.util.List;
import com.squareup.moshi.Json;

public class PlaylistEditEndpoint{

	@Json(name="playlistId")
	private String playlistId;

	@Json(name="actions")
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