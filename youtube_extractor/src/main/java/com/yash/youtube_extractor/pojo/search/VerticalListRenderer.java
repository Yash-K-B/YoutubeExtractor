package com.yash.youtube_extractor.pojo.search;

import java.util.List;
import com.squareup.moshi.Json;

public class VerticalListRenderer{

	@Json(name="trackingParams")
	private String trackingParams;

	@Json(name="collapsedItemCount")
	private Integer collapsedItemCount;

	@Json(name="collapsedStateButtonText")
	private CollapsedStateButtonText collapsedStateButtonText;

	@Json(name="items")
	private List<ItemsItem> items;

	public void setTrackingParams(String trackingParams){
		this.trackingParams = trackingParams;
	}

	public String getTrackingParams(){
		return trackingParams;
	}

	public void setCollapsedItemCount(Integer collapsedItemCount){
		this.collapsedItemCount = collapsedItemCount;
	}

	public Integer getCollapsedItemCount(){
		return collapsedItemCount;
	}

	public void setCollapsedStateButtonText(CollapsedStateButtonText collapsedStateButtonText){
		this.collapsedStateButtonText = collapsedStateButtonText;
	}

	public CollapsedStateButtonText getCollapsedStateButtonText(){
		return collapsedStateButtonText;
	}

	public void setItems(List<ItemsItem> items){
		this.items = items;
	}

	public List<ItemsItem> getItems(){
		return items;
	}

	@Override
 	public String toString(){
		return 
			"VerticalListRenderer{" + 
			"trackingParams = '" + trackingParams + '\'' + 
			",collapsedItemCount = '" + collapsedItemCount + '\'' + 
			",collapsedStateButtonText = '" + collapsedStateButtonText + '\'' + 
			",items = '" + items + '\'' + 
			"}";
		}
}