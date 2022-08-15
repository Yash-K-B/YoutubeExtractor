package com.yash.youtube_extractor.pojo.search;

import com.squareup.moshi.Json;

public class BadgesItem{

	@Json(name="metadataBadgeRenderer")
	private MetadataBadgeRenderer metadataBadgeRenderer;

	public void setMetadataBadgeRenderer(MetadataBadgeRenderer metadataBadgeRenderer){
		this.metadataBadgeRenderer = metadataBadgeRenderer;
	}

	public MetadataBadgeRenderer getMetadataBadgeRenderer(){
		return metadataBadgeRenderer;
	}

	@Override
 	public String toString(){
		return 
			"BadgesItem{" + 
			"metadataBadgeRenderer = '" + metadataBadgeRenderer + '\'' + 
			"}";
		}
}