package com.yash.youtubeextractor.pojo.search;

import java.util.List;
import lombok.Data;

@Data
public class VerticalListRenderer{
	private String trackingParams;
	private Integer collapsedItemCount;
	private CollapsedStateButtonText collapsedStateButtonText;
	private List<ItemsItem> items;
}