package com.yash.youtubeextractor.pojo.search;

import lombok.Data;

@Data
public class ContentsItem{
	private ContinuationItemRenderer continuationItemRenderer;
	private ItemSectionRenderer itemSectionRenderer;
	private VideoRenderer videoRenderer;
	private ShelfRenderer shelfRenderer;
}