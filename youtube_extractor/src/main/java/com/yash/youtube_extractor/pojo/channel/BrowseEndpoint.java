package com.yash.youtube_extractor.pojo.channel;

import com.squareup.moshi.Json;

public class BrowseEndpoint{

	@Json(name = "browseId")
	private String browseId;

	@Json(name = "canonicalBaseUrl")
	private String canonicalBaseUrl;

	@Json(name = "params")
	private String params;

	public void setBrowseId(String browseId){
		this.browseId = browseId;
	}

	public String getBrowseId(){
		return browseId;
	}

	public void setCanonicalBaseUrl(String canonicalBaseUrl){
		this.canonicalBaseUrl = canonicalBaseUrl;
	}

	public String getCanonicalBaseUrl(){
		return canonicalBaseUrl;
	}

	public void setParams(String params){
		this.params = params;
	}

	public String getParams(){
		return params;
	}

	@Override
 	public String toString(){
		return 
			"BrowseEndpoint{" + 
			"browseId = '" + browseId + '\'' + 
			",canonicalBaseUrl = '" + canonicalBaseUrl + '\'' + 
			",params = '" + params + '\'' + 
			"}";
		}
}