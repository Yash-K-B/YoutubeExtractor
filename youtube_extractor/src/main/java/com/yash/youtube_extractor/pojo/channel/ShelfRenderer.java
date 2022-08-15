package com.yash.youtube_extractor.pojo.channel;

import com.squareup.moshi.Json;

public class ShelfRenderer{

	@Json(name = "endpoint")
	private Endpoint endpoint;

	@Json(name = "trackingParams")
	private String trackingParams;

	@Json(name = "title")
	private Title title;

	@Json(name = "content")
	private Content content;

	public void setEndpoint(Endpoint endpoint){
		this.endpoint = endpoint;
	}

	public Endpoint getEndpoint(){
		return endpoint;
	}

	public void setTrackingParams(String trackingParams){
		this.trackingParams = trackingParams;
	}

	public String getTrackingParams(){
		return trackingParams;
	}

	public void setTitle(Title title){
		this.title = title;
	}

	public Title getTitle(){
		return title;
	}

	public void setContent(Content content){
		this.content = content;
	}

	public Content getContent(){
		return content;
	}

	@Override
 	public String toString(){
		return 
			"ShelfRenderer{" + 
			"endpoint = '" + endpoint + '\'' + 
			",trackingParams = '" + trackingParams + '\'' + 
			",title = '" + title + '\'' + 
			",content = '" + content + '\'' + 
			"}";
		}
}