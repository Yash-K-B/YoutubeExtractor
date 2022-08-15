package com.yash.youtube_extractor.pojo.search;

import com.squareup.moshi.Json;

public class ServiceEndpoint{

	@Json(name="commandMetadata")
	private CommandMetadata commandMetadata;

	@Json(name="clickTrackingParams")
	private String clickTrackingParams;

	@Json(name="signalServiceEndpoint")
	private SignalServiceEndpoint signalServiceEndpoint;

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
			"commandMetadata = '" + commandMetadata + '\'' + 
			",clickTrackingParams = '" + clickTrackingParams + '\'' + 
			",signalServiceEndpoint = '" + signalServiceEndpoint + '\'' + 
			"}";
		}
}