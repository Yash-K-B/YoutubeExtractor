package com.yash.youtubeextractor.pojo.search;

import lombok.Data;

@Data
public class MenuServiceItemRenderer{
	private String trackingParams;
	private Icon icon;
	private Text text;
	private ServiceEndpoint serviceEndpoint;
}