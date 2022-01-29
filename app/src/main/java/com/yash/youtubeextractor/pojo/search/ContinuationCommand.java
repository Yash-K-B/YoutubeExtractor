package com.yash.youtubeextractor.pojo.search;

import lombok.Data;

@Data
public class ContinuationCommand{
	private String request;
	private String token;
}