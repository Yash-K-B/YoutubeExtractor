package com.yash.youtubeextractor.pojo.search;

import lombok.Data;

@Data
public class ThumbnailOverlayToggleButtonRenderer{
	private UntoggledIcon untoggledIcon;
	private ToggledIcon toggledIcon;
	private String toggledTooltip;
	private String trackingParams;
	private ToggledAccessibility toggledAccessibility;
	private String untoggledTooltip;
	private UntoggledAccessibility untoggledAccessibility;
	private UntoggledServiceEndpoint untoggledServiceEndpoint;
	private ToggledServiceEndpoint toggledServiceEndpoint;
	private Boolean isToggled;
}