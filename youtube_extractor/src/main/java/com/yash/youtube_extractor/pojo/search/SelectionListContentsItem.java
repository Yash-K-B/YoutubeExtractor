package com.yash.youtube_extractor.pojo.search;

import com.squareup.moshi.Json;

public class SelectionListContentsItem{

	@Json(name="itemSectionRenderer")
	private ItemSectionRenderer itemSectionRenderer;

	public void setItemSectionRenderer(ItemSectionRenderer itemSectionRenderer){
		this.itemSectionRenderer = itemSectionRenderer;
	}

	public ItemSectionRenderer getItemSectionRenderer(){
		return itemSectionRenderer;
	}

	@Override
	public String toString() {
		return "ContentsItem{" +
				"itemSectionRenderer=" + itemSectionRenderer +
				'}';
	}
}