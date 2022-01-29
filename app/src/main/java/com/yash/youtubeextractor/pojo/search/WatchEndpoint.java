package com.yash.youtubeextractor.pojo.search;

import lombok.Data;

@Data
public class WatchEndpoint{
	private WatchEndpointSupportedOnesieConfig watchEndpointSupportedOnesieConfig;
	private String videoId;
	private String params;
}