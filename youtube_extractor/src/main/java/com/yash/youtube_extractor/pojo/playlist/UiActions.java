package com.yash.youtube_extractor.pojo.playlist;

import com.squareup.moshi.Json;

public class UiActions{

	@Json(name="hideEnclosingContainer")
	private Boolean hideEnclosingContainer;

	public void setHideEnclosingContainer(Boolean hideEnclosingContainer){
		this.hideEnclosingContainer = hideEnclosingContainer;
	}

	public Boolean isHideEnclosingContainer(){
		return hideEnclosingContainer;
	}

	@Override
 	public String toString(){
		return 
			"UiActions{" + 
			"hideEnclosingContainer = '" + hideEnclosingContainer + '\'' + 
			"}";
		}
}