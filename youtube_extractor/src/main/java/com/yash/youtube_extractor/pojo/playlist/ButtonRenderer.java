package com.yash.youtube_extractor.pojo.playlist;

import com.squareup.moshi.Json;

public class ButtonRenderer{

	@Json(name="trackingParams")
	private String trackingParams;

	@Json(name="size")
	private String size;

	@Json(name="accessibilityData")
	private AccessibilityData accessibilityData;

	@Json(name="icon")
	private Icon icon;

	@Json(name="tooltip")
	private String tooltip;

	@Json(name="style")
	private String style;

	@Json(name="isDisabled")
	private Boolean isDisabled;

	@Json(name="serviceEndpoint")
	private ServiceEndpoint serviceEndpoint;

	public void setTrackingParams(String trackingParams){
		this.trackingParams = trackingParams;
	}

	public String getTrackingParams(){
		return trackingParams;
	}

	public void setSize(String size){
		this.size = size;
	}

	public String getSize(){
		return size;
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

	public void setStyle(String style){
		this.style = style;
	}

	public String getStyle(){
		return style;
	}

	public void setIsDisabled(Boolean isDisabled){
		this.isDisabled = isDisabled;
	}

	public Boolean isIsDisabled(){
		return isDisabled;
	}

	public void setServiceEndpoint(ServiceEndpoint serviceEndpoint){
		this.serviceEndpoint = serviceEndpoint;
	}

	public ServiceEndpoint getServiceEndpoint(){
		return serviceEndpoint;
	}

	@Override
 	public String toString(){
		return 
			"ButtonRenderer{" + 
			"trackingParams = '" + trackingParams + '\'' + 
			",size = '" + size + '\'' + 
			",accessibilityData = '" + accessibilityData + '\'' + 
			",icon = '" + icon + '\'' + 
			",tooltip = '" + tooltip + '\'' + 
			",style = '" + style + '\'' + 
			",isDisabled = '" + isDisabled + '\'' + 
			",serviceEndpoint = '" + serviceEndpoint + '\'' + 
			"}";
		}
}