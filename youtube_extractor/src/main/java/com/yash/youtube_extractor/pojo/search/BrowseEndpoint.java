package com.yash.youtube_extractor.pojo.search;

import com.squareup.moshi.Json;

public class BrowseEndpoint{

	@Json(name="browseId")
	private String browseId;

	@Json(name="canonicalBaseUrl")
	private String canonicalBaseUrl;

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

	@Override
 	public String toString(){
		return 
			"BrowseEndpoint{" + 
			"browseId = '" + browseId + '\'' + 
			",canonicalBaseUrl = '" + canonicalBaseUrl + '\'' + 
			"}";
		}
}