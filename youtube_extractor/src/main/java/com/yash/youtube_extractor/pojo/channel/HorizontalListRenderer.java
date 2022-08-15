package com.yash.youtube_extractor.pojo.channel;

import java.util.List;
import com.squareup.moshi.Json;

public class HorizontalListRenderer{

	@Json(name = "nextButton")
	private NextButton nextButton;

	@Json(name = "trackingParams")
	private String trackingParams;

	@Json(name = "previousButton")
	private PreviousButton previousButton;

	@Json(name = "visibleItemCount")
	private Integer visibleItemCount;

	@Json(name = "items")
	private List<PlaylistItem> items;

	public void setNextButton(NextButton nextButton){
		this.nextButton = nextButton;
	}

	public NextButton getNextButton(){
		return nextButton;
	}

	public void setTrackingParams(String trackingParams){
		this.trackingParams = trackingParams;
	}

	public String getTrackingParams(){
		return trackingParams;
	}

	public void setPreviousButton(PreviousButton previousButton){
		this.previousButton = previousButton;
	}

	public PreviousButton getPreviousButton(){
		return previousButton;
	}

	public void setVisibleItemCount(Integer visibleItemCount){
		this.visibleItemCount = visibleItemCount;
	}

	public Integer getVisibleItemCount(){
		return visibleItemCount;
	}

	public void setItems(List<PlaylistItem> items){
		this.items = items;
	}

	public List<PlaylistItem> getItems(){
		return items;
	}

	@Override
 	public String toString(){
		return 
			"HorizontalListRenderer{" + 
			"nextButton = '" + nextButton + '\'' + 
			",trackingParams = '" + trackingParams + '\'' + 
			",previousButton = '" + previousButton + '\'' + 
			",visibleItemCount = '" + visibleItemCount + '\'' + 
			",items = '" + items + '\'' + 
			"}";
		}
}