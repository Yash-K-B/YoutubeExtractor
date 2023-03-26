package com.yash.youtube_extractor.pojo.playlist;

import java.util.List;
import com.squareup.moshi.Json;

public class MenuRenderer{

	@Json(name="trackingParams")
	private String trackingParams;

	@Json(name="accessibility")
	private Accessibility accessibility;

	@Json(name="topLevelButtons")
	private List<TopLevelButtonsItem> topLevelButtons;

	@Json(name="items")
	private List<ItemsItem> items;

	public void setTrackingParams(String trackingParams){
		this.trackingParams = trackingParams;
	}

	public String getTrackingParams(){
		return trackingParams;
	}

	public void setAccessibility(Accessibility accessibility){
		this.accessibility = accessibility;
	}

	public Accessibility getAccessibility(){
		return accessibility;
	}

	public void setTopLevelButtons(List<TopLevelButtonsItem> topLevelButtons){
		this.topLevelButtons = topLevelButtons;
	}

	public List<TopLevelButtonsItem> getTopLevelButtons(){
		return topLevelButtons;
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
			"MenuRenderer{" + 
			"trackingParams = '" + trackingParams + '\'' + 
			",accessibility = '" + accessibility + '\'' + 
			",topLevelButtons = '" + topLevelButtons + '\'' + 
			",items = '" + items + '\'' + 
			"}";
		}
}