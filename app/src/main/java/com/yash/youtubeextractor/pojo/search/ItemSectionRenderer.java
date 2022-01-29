package com.yash.youtubeextractor.pojo.search;

import java.util.List;
import lombok.Data;

@Data
public class ItemSectionRenderer{
	private String trackingParams;
	private List<ContentsItem> contents;
}