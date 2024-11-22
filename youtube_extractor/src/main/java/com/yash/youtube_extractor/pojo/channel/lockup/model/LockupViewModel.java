package com.yash.youtube_extractor.pojo.channel.lockup.model;

import lombok.Data;

@Data
public class LockupViewModel{
	private Metadata metadata;
	private RendererContext rendererContext;
	private String contentId;
	private ContentImage contentImage;
	private String contentType;
}