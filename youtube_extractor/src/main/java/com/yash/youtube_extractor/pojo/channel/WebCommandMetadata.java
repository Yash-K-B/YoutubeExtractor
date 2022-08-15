package com.yash.youtube_extractor.pojo.channel;

import com.squareup.moshi.Json;

public class WebCommandMetadata{

	@Json(name = "apiUrl")
	private String apiUrl;

	@Json(name = "rootVe")
	private Integer rootVe;

	@Json(name = "webPageType")
	private String webPageType;

	@Json(name = "url")
	private String url;

	public void setApiUrl(String apiUrl){
		this.apiUrl = apiUrl;
	}

	public String getApiUrl(){
		return apiUrl;
	}

	public void setRootVe(Integer rootVe){
		this.rootVe = rootVe;
	}

	public Integer getRootVe(){
		return rootVe;
	}

	public void setWebPageType(String webPageType){
		this.webPageType = webPageType;
	}

	public String getWebPageType(){
		return webPageType;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	@Override
 	public String toString(){
		return 
			"WebCommandMetadata{" + 
			"apiUrl = '" + apiUrl + '\'' + 
			",rootVe = '" + rootVe + '\'' + 
			",webPageType = '" + webPageType + '\'' + 
			",url = '" + url + '\'' + 
			"}";
		}
}