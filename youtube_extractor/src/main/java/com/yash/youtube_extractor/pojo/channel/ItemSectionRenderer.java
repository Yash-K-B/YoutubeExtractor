package com.yash.youtube_extractor.pojo.channel;

import java.util.List;
import com.squareup.moshi.Json;

public class ItemSectionRenderer{

	@Json(name = "trackingParams")
	private String trackingParams;

	@Json(name = "contents")
	private List<ContentsItem> contents;

	public void setTrackingParams(String trackingParams){
		this.trackingParams = trackingParams;
	}

	public String getTrackingParams(){
		return trackingParams;
	}

	public void setContents(List<ContentsItem> contents){
		this.contents = contents;
	}

	public List<ContentsItem> getContents(){
		return contents;
	}

	@Override
 	public String toString(){
		return 
			"ItemSectionRenderer{" + 
			"trackingParams = '" + trackingParams + '\'' + 
			",contents = '" + contents + '\'' + 
			"}";
		}
}