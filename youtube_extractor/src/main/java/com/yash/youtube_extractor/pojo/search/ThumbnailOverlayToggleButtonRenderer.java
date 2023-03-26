package com.yash.youtube_extractor.pojo.search;

import com.squareup.moshi.Json;

public class ThumbnailOverlayToggleButtonRenderer{

	@Json(name="untoggledIcon")
	private UntoggledIcon untoggledIcon;

	@Json(name="toggledIcon")
	private ToggledIcon toggledIcon;

	@Json(name="toggledTooltip")
	private String toggledTooltip;

	@Json(name="trackingParams")
	private String trackingParams;

	@Json(name="toggledAccessibility")
	private ToggledAccessibility toggledAccessibility;

	@Json(name="untoggledTooltip")
	private String untoggledTooltip;

	@Json(name="untoggledAccessibility")
	private UntoggledAccessibility untoggledAccessibility;

	@Json(name="untoggledServiceEndpoint")
	private UntoggledServiceEndpoint untoggledServiceEndpoint;

	@Json(name="toggledServiceEndpoint")
	private ToggledServiceEndpoint toggledServiceEndpoint;

	@Json(name="isToggled")
	private Boolean isToggled;

	public void setUntoggledIcon(UntoggledIcon untoggledIcon){
		this.untoggledIcon = untoggledIcon;
	}

	public UntoggledIcon getUntoggledIcon(){
		return untoggledIcon;
	}

	public void setToggledIcon(ToggledIcon toggledIcon){
		this.toggledIcon = toggledIcon;
	}

	public ToggledIcon getToggledIcon(){
		return toggledIcon;
	}

	public void setToggledTooltip(String toggledTooltip){
		this.toggledTooltip = toggledTooltip;
	}

	public String getToggledTooltip(){
		return toggledTooltip;
	}

	public void setTrackingParams(String trackingParams){
		this.trackingParams = trackingParams;
	}

	public String getTrackingParams(){
		return trackingParams;
	}

	public void setToggledAccessibility(ToggledAccessibility toggledAccessibility){
		this.toggledAccessibility = toggledAccessibility;
	}

	public ToggledAccessibility getToggledAccessibility(){
		return toggledAccessibility;
	}

	public void setUntoggledTooltip(String untoggledTooltip){
		this.untoggledTooltip = untoggledTooltip;
	}

	public String getUntoggledTooltip(){
		return untoggledTooltip;
	}

	public void setUntoggledAccessibility(UntoggledAccessibility untoggledAccessibility){
		this.untoggledAccessibility = untoggledAccessibility;
	}

	public UntoggledAccessibility getUntoggledAccessibility(){
		return untoggledAccessibility;
	}

	public void setUntoggledServiceEndpoint(UntoggledServiceEndpoint untoggledServiceEndpoint){
		this.untoggledServiceEndpoint = untoggledServiceEndpoint;
	}

	public UntoggledServiceEndpoint getUntoggledServiceEndpoint(){
		return untoggledServiceEndpoint;
	}

	public void setToggledServiceEndpoint(ToggledServiceEndpoint toggledServiceEndpoint){
		this.toggledServiceEndpoint = toggledServiceEndpoint;
	}

	public ToggledServiceEndpoint getToggledServiceEndpoint(){
		return toggledServiceEndpoint;
	}

	public void setIsToggled(Boolean isToggled){
		this.isToggled = isToggled;
	}

	public Boolean isIsToggled(){
		return isToggled;
	}

	@Override
 	public String toString(){
		return 
			"ThumbnailOverlayToggleButtonRenderer{" + 
			"untoggledIcon = '" + untoggledIcon + '\'' + 
			",toggledIcon = '" + toggledIcon + '\'' + 
			",toggledTooltip = '" + toggledTooltip + '\'' + 
			",trackingParams = '" + trackingParams + '\'' + 
			",toggledAccessibility = '" + toggledAccessibility + '\'' + 
			",untoggledTooltip = '" + untoggledTooltip + '\'' + 
			",untoggledAccessibility = '" + untoggledAccessibility + '\'' + 
			",untoggledServiceEndpoint = '" + untoggledServiceEndpoint + '\'' + 
			",toggledServiceEndpoint = '" + toggledServiceEndpoint + '\'' + 
			",isToggled = '" + isToggled + '\'' + 
			"}";
		}
}