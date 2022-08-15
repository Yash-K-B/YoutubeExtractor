package com.yash.youtube_extractor.pojo.search;

import com.squareup.moshi.Json;

public class ChannelThumbnailSupportedRenderers{

	@Json(name="channelThumbnailWithLinkRenderer")
	private ChannelThumbnailWithLinkRenderer channelThumbnailWithLinkRenderer;

	public void setChannelThumbnailWithLinkRenderer(ChannelThumbnailWithLinkRenderer channelThumbnailWithLinkRenderer){
		this.channelThumbnailWithLinkRenderer = channelThumbnailWithLinkRenderer;
	}

	public ChannelThumbnailWithLinkRenderer getChannelThumbnailWithLinkRenderer(){
		return channelThumbnailWithLinkRenderer;
	}

	@Override
 	public String toString(){
		return 
			"ChannelThumbnailSupportedRenderers{" + 
			"channelThumbnailWithLinkRenderer = '" + channelThumbnailWithLinkRenderer + '\'' + 
			"}";
		}
}