package com.yash.youtubeextractor.pojo.search;

import lombok.Data;

@Data
public class ActionsItem{
	private String clickTrackingParams;
	private AddToPlaylistCommand addToPlaylistCommand;
	private String addedVideoId;
	private String action;
	private String removedVideoId;
}