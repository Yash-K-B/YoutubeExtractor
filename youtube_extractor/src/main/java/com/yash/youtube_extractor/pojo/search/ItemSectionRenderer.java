package com.yash.youtube_extractor.pojo.search;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ItemSectionRenderer{

	@SerializedName("trackingParams")
	private String trackingParams;

	@SerializedName("contents")
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