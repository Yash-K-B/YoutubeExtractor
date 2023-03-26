package com.yash.youtube_extractor.pojo.playlist;

import com.squareup.moshi.Json;

public class MenuServiceItemRenderer{

	@Json(name="hasSeparator")
	private Boolean hasSeparator;

	@Json(name="trackingParams")
	private String trackingParams;

	@Json(name="icon")
	private Icon icon;

	@Json(name="text")
	private Text text;

	@Json(name="serviceEndpoint")
	private ServiceEndpoint serviceEndpoint;

	public void setHasSeparator(Boolean hasSeparator){
		this.hasSeparator = hasSeparator;
	}

	public Boolean isHasSeparator(){
		return hasSeparator;
	}

	public void setTrackingParams(String trackingParams){
		this.trackingParams = trackingParams;
	}

	public String getTrackingParams(){
		return trackingParams;
	}

	public void setIcon(Icon icon){
		this.icon = icon;
	}

	public Icon getIcon(){
		return icon;
	}

	public void setText(Text text){
		this.text = text;
	}

	public Text getText(){
		return text;
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
			"MenuServiceItemRenderer{" + 
			"hasSeparator = '" + hasSeparator + '\'' + 
			",trackingParams = '" + trackingParams + '\'' + 
			",icon = '" + icon + '\'' + 
			",text = '" + text + '\'' + 
			",serviceEndpoint = '" + serviceEndpoint + '\'' + 
			"}";
		}
}