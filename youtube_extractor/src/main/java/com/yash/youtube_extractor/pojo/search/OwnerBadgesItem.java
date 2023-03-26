package com.yash.youtube_extractor.pojo.search;

import com.squareup.moshi.Json;

public class OwnerBadgesItem{

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
			"OwnerBadgesItem{" + 
			"metadataBadgeRenderer = '" + metadataBadgeRenderer + '\'' + 
			"}";
		}
}