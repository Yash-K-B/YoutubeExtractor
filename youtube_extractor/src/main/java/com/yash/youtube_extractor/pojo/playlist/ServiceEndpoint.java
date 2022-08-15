package com.yash.youtube_extractor.pojo.playlist;

import com.squareup.moshi.Json;

public class ServiceEndpoint{

	@Json(name="feedbackEndpoint")
	private FeedbackEndpoint feedbackEndpoint;

	@Json(name="commandMetadata")
	private CommandMetadata commandMetadata;

	@Json(name="clickTrackingParams")
	private String clickTrackingParams;

	@Json(name="addToPlaylistServiceEndpoint")
	private AddToPlaylistServiceEndpoint addToPlaylistServiceEndpoint;

	@Json(name="playlistEditEndpoint")
	private PlaylistEditEndpoint playlistEditEndpoint;

	@Json(name="signalServiceEndpoint")
	private SignalServiceEndpoint signalServiceEndpoint;

	public void setFeedbackEndpoint(FeedbackEndpoint feedbackEndpoint){
		this.feedbackEndpoint = feedbackEndpoint;
	}

	public FeedbackEndpoint getFeedbackEndpoint(){
		return feedbackEndpoint;
	}

	public void setCommandMetadata(CommandMetadata commandMetadata){
		this.commandMetadata = commandMetadata;
	}

	public CommandMetadata getCommandMetadata(){
		return commandMetadata;
	}

	public void setClickTrackingParams(String clickTrackingParams){
		this.clickTrackingParams = clickTrackingParams;
	}

	public String getClickTrackingParams(){
		return clickTrackingParams;
	}

	public void setAddToPlaylistServiceEndpoint(AddToPlaylistServiceEndpoint addToPlaylistServiceEndpoint){
		this.addToPlaylistServiceEndpoint = addToPlaylistServiceEndpoint;
	}

	public AddToPlaylistServiceEndpoint getAddToPlaylistServiceEndpoint(){
		return addToPlaylistServiceEndpoint;
	}

	public void setPlaylistEditEndpoint(PlaylistEditEndpoint playlistEditEndpoint){
		this.playlistEditEndpoint = playlistEditEndpoint;
	}

	public PlaylistEditEndpoint getPlaylistEditEndpoint(){
		return playlistEditEndpoint;
	}

	public void setSignalServiceEndpoint(SignalServiceEndpoint signalServiceEndpoint){
		this.signalServiceEndpoint = signalServiceEndpoint;
	}

	public SignalServiceEndpoint getSignalServiceEndpoint(){
		return signalServiceEndpoint;
	}

	@Override
 	public String toString(){
		return 
			"ServiceEndpoint{" + 
			"feedbackEndpoint = '" + feedbackEndpoint + '\'' + 
			",commandMetadata = '" + commandMetadata + '\'' + 
			",clickTrackingParams = '" + clickTrackingParams + '\'' + 
			",addToPlaylistServiceEndpoint = '" + addToPlaylistServiceEndpoint + '\'' + 
			",playlistEditEndpoint = '" + playlistEditEndpoint + '\'' + 
			",signalServiceEndpoint = '" + signalServiceEndpoint + '\'' + 
			"}";
		}
}