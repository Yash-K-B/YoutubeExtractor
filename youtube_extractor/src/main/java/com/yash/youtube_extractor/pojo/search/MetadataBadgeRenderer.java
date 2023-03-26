package com.yash.youtube_extractor.pojo.search;

import com.squareup.moshi.Json;

public class MetadataBadgeRenderer{

	@Json(name="trackingParams")
	private String trackingParams;

	@Json(name="style")
	private String style;

	@Json(name="label")
	private String label;

	@Json(name="accessibilityData")
	private AccessibilityData accessibilityData;

	@Json(name="icon")
	private Icon icon;

	@Json(name="tooltip")
	private String tooltip;

	public void setTrackingParams(String trackingParams){
		this.trackingParams = trackingParams;
	}

	public String getTrackingParams(){
		return trackingParams;
	}

	public void setStyle(String style){
		this.style = style;
	}

	public String getStyle(){
		return style;
	}

	public void setLabel(String label){
		this.label = label;
	}

	public String getLabel(){
		return label;
	}

	public void setAccessibilityData(AccessibilityData accessibilityData){
		this.accessibilityData = accessibilityData;
	}

	public AccessibilityData getAccessibilityData(){
		return accessibilityData;
	}

	public void setIcon(Icon icon){
		this.icon = icon;
	}

	public Icon getIcon(){
		return icon;
	}

	public void setTooltip(String tooltip){
		this.tooltip = tooltip;
	}

	public String getTooltip(){
		return tooltip;
	}

	@Override
 	public String toString(){
		return 
			"MetadataBadgeRenderer{" + 
			"trackingParams = '" + trackingParams + '\'' + 
			",style = '" + style + '\'' + 
			",label = '" + label + '\'' + 
			",accessibilityData = '" + accessibilityData + '\'' + 
			",icon = '" + icon + '\'' + 
			",tooltip = '" + tooltip + '\'' + 
			"}";
		}
}