package com.yash.youtubeextractor.pojo.search;

import java.util.List;
import lombok.Data;

@Data
public class MenuRenderer{
	private String trackingParams;
	private Accessibility accessibility;
	private List<ItemsItem> items;
}