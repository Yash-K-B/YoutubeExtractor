package com.yash.youtube_extractor.pojo.search;

import java.util.List;
import com.squareup.moshi.Json;

public class CreatePlaylistServiceEndpoint{

	@Json(name="params")
	private String params;

	@Json(name="videoIds")
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