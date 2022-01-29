package com.yash.youtube_extractor.pojo.search;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class CreatePlaylistServiceEndpoint{

	@SerializedName("params")
	private String params;

	@SerializedName("videoIds")
	private List<String> videoIds;

	public void setParams(String params){
		this.params = params;
	}

	public String getParams(){
		return params;
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
			"CreatePlaylistServiceEndpoint{" + 
			"params = '" + params + '\'' + 
			",videoIds = '" + videoIds + '\'' + 
			"}";
		}
}