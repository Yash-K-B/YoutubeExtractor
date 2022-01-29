package com.yash.youtube_extractor.pojo.search;

import com.google.gson.annotations.SerializedName;

public class OwnerBadgesItem{

	@SerializedName("metadataBadgeRenderer")
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