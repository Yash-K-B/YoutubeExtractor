package com.yash.youtube_extractor.pojo.channel.lockup.model;

import lombok.Data;

@Data
public class SourcesItem{
	private Integer width;
	private String url;
	private Integer height;
	private ClientResource clientResource;
}