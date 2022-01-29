package com.yash.youtubeextractor.pojo.search;

import lombok.Data;

@Data
public class ServiceEndpoint{
	private CommandMetadata commandMetadata;
	private String clickTrackingParams;
	private SignalServiceEndpoint signalServiceEndpoint;
}