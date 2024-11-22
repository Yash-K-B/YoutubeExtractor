package com.yash.youtube_extractor.pojo.channel.lockup.model;

import lombok.Data;

@Data
public class LoggingDirectives{
	private String trackingParams;
	private ClientVeSpec clientVeSpec;
	private Boolean enableDisplayloggerExperiment;
}