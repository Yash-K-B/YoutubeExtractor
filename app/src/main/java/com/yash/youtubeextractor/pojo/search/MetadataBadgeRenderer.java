package com.yash.youtubeextractor.pojo.search;

import lombok.Data;

@Data
public class MetadataBadgeRenderer{
	private String trackingParams;
	private String style;
	private String label;
	private AccessibilityData accessibilityData;
	private Icon icon;
	private String tooltip;
}