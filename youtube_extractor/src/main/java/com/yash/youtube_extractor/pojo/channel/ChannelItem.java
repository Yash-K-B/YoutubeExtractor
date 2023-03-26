package com.yash.youtube_extractor.pojo.channel;

import com.squareup.moshi.Json;

public class ChannelItem{

	@Json(name = "itemSectionRenderer")
	private ItemSectionRenderer itemSectionRenderer;

	public void setItemSectionRenderer(ItemSectionRenderer itemSectionRenderer){
		this.itemSectionRenderer = itemSectionRenderer;
	}

	public ItemSectionRenderer getItemSectionRenderer(){
		return itemSectionRenderer;
	}

	@Override
 	public String toString(){
		return 
			"ChannelItem{" + 
			"itemSectionRenderer = '" + itemSectionRenderer + '\'' + 
			"}";
		}
}