package com.yash.youtube_extractor.pojo.search;

import java.util.List;
import com.squareup.moshi.Json;

public class ItemSectionRenderer{

	@Json(name="trackingParams")
	private String trackingParams;

	@Json(name="contents")
	private List<ItemSelectionContentsItem> contents;

	public void setTrackingParams(String trackingParams){
		this.trackingParams = trackingParams;
	}

	public String getTrackingParams(){
		return trackingParams;
	}

	public void setContents(List<ItemSelectionContentsItem> contents){
		this.contents = contents;
	}

	public List<ItemSelectionContentsItem> getContents(){
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