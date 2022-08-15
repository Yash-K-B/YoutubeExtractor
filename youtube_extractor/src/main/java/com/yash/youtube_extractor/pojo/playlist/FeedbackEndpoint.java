package com.yash.youtube_extractor.pojo.playlist;

import com.squareup.moshi.Json;

public class FeedbackEndpoint{

	@Json(name="uiActions")
	private UiActions uiActions;

	@Json(name="feedbackToken")
	private String feedbackToken;

	public void setUiActions(UiActions uiActions){
		this.uiActions = uiActions;
	}

	public UiActions getUiActions(){
		return uiActions;
	}

	public void setFeedbackToken(String feedbackToken){
		this.feedbackToken = feedbackToken;
	}

	public String getFeedbackToken(){
		return feedbackToken;
	}

	@Override
 	public String toString(){
		return 
			"FeedbackEndpoint{" + 
			"uiActions = '" + uiActions + '\'' + 
			",feedbackToken = '" + feedbackToken + '\'' + 
			"}";
		}
}