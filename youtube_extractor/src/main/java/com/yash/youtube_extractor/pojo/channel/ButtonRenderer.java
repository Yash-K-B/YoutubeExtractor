package com.yash.youtube_extractor.pojo.channel;

import com.squareup.moshi.Json;

public class ButtonRenderer{

	@Json(name = "trackingParams")
	private String trackingParams;

	@Json(name = "size")
	private String size;

	@Json(name = "accessibility")
	private Accessibility accessibility;

	@Json(name = "icon")
	private Icon icon;

	@Json(name = "style")
	private String style;

	@Json(name = "isDisabled")
	private Boolean isDisabled;

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

	public void setAccessibility(Accessibility accessibility){
		this.accessibility = accessibility;
	}

	public Accessibility getAccessibility(){
		return accessibility;
	}

	public void setIcon(Icon icon){
		this.icon = icon;
	}

	public Icon getIcon(){
		return icon;
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

	@Override
 	public String toString(){
		return 
			"ButtonRenderer{" + 
			"trackingParams = '" + trackingParams + '\'' + 
			",size = '" + size + '\'' + 
			",accessibility = '" + accessibility + '\'' + 
			",icon = '" + icon + '\'' + 
			",style = '" + style + '\'' + 
			",isDisabled = '" + isDisabled + '\'' + 
			"}";
		}
}