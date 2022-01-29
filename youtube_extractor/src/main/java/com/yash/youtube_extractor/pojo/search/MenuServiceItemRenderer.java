package com.yash.youtube_extractor.pojo.search;

import com.google.gson.annotations.SerializedName;

public class MenuServiceItemRenderer{

	@SerializedName("trackingParams")
	private String trackingParams;

	@SerializedName("icon")
	private Icon icon;

	@SerializedName("text")
	private Text text;

	@SerializedName("serviceEndpoint")
	private ServiceEndpoint serviceEndpoint;

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
			"trackingParams = '" + trackingParams + '\'' + 
			",icon = '" + icon + '\'' + 
			",text = '" + text + '\'' + 
			",serviceEndpoint = '" + serviceEndpoint + '\'' + 
			"}";
		}
}