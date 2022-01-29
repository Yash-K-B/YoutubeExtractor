package com.yash.youtube_extractor.pojo.search;

import com.google.gson.annotations.SerializedName;

public class ServiceEndpoint{

	@SerializedName("commandMetadata")
	private CommandMetadata commandMetadata;

	@SerializedName("clickTrackingParams")
	private String clickTrackingParams;

	@SerializedName("signalServiceEndpoint")
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