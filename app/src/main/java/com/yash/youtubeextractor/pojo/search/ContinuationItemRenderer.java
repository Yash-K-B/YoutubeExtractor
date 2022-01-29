package com.yash.youtubeextractor.pojo.search;

import lombok.Data;

@Data
public class ContinuationItemRenderer{
	private ContinuationEndpoint continuationEndpoint;
	private String trigger;
}