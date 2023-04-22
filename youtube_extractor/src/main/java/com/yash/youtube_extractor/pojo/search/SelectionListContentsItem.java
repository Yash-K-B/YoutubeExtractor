package com.yash.youtube_extractor.pojo.search;

import com.squareup.moshi.Json;
import com.yash.youtube_extractor.pojo.playlist.ContinuationItemRenderer;

public class SelectionListContentsItem{

	@Json(name="itemSectionRenderer")
	private ItemSectionRenderer itemSectionRenderer;

	@Json(name = "continuationItemRenderer")
	private ContinuationItemRenderer continuationItemRenderer;

	public ItemSectionRenderer getItemSectionRenderer() {
		return itemSectionRenderer;
	}

	public void setItemSectionRenderer(ItemSectionRenderer itemSectionRenderer) {
		this.itemSectionRenderer = itemSectionRenderer;
	}

	public ContinuationItemRenderer getContinuationItemRenderer() {
		return continuationItemRenderer;
	}

	public void setContinuationItemRenderer(ContinuationItemRenderer continuationItemRenderer) {
		this.continuationItemRenderer = continuationItemRenderer;
	}

	@Override
	public String toString() {
		return "SelectionListContentsItem{" +
				"itemSectionRenderer=" + itemSectionRenderer +
				", continuationItemRenderer=" + continuationItemRenderer +
				'}';
	}
}