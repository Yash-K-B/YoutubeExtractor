package com.yash.youtubeextractor.pojo.search;

import lombok.Data;

@Data
public class RunsItem{
	private String text;
	private Boolean bold;
	private NavigationEndpoint navigationEndpoint;
}