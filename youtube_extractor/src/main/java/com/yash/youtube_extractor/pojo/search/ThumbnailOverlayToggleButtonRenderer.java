package com.yash.youtube_extractor.pojo.search;

import com.google.gson.annotations.SerializedName;

public class ThumbnailOverlayToggleButtonRenderer{

	@SerializedName("untoggledIcon")
	private UntoggledIcon untoggledIcon;

	@SerializedName("toggledIcon")
	private ToggledIcon toggledIcon;

	@SerializedName("toggledTooltip")
	private String toggledTooltip;

	@SerializedName("trackingParams")
	private String trackingParams;

	@SerializedName("toggledAccessibility")
	private ToggledAccessibility toggledAccessibility;

	@SerializedName("untoggledTooltip")
	private String untoggledTooltip;

	@SerializedName("untoggledAccessibility")
	private UntoggledAccessibility untoggledAccessibility;

	@SerializedName("untoggledServiceEndpoint")
	private UntoggledServiceEndpoint untoggledServiceEndpoint;

	@SerializedName("toggledServiceEndpoint")
	private ToggledServiceEndpoint toggledServiceEndpoint;

	@SerializedName("isToggled")
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