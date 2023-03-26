package com.yash.youtube_extractor.pojo.playlist;

import com.squareup.moshi.Json;

public class WebCommandMetadata{

	@Json(name="rootVe")
	private Integer rootVe;

	@Json(name="webPageType")
	private String webPageType;

	@Json(name="url")
	private String url;

	@Json(name="apiUrl")
	private String apiUrl;

	@Json(name="sendPost")
	private Boolean sendPost;

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

	public void setApiUrl(String apiUrl){
		this.apiUrl = apiUrl;
	}

	public String getApiUrl(){
		return apiUrl;
	}

	public void setSendPost(Boolean sendPost){
		this.sendPost = sendPost;
	}

	public Boolean isSendPost(){
		return sendPost;
	}

	@Override
 	public String toString(){
		return 
			"WebCommandMetadata{" + 
			"rootVe = '" + rootVe + '\'' + 
			",webPageType = '" + webPageType + '\'' + 
			",url = '" + url + '\'' + 
			",apiUrl = '" + apiUrl + '\'' + 
			",sendPost = '" + sendPost + '\'' + 
			"}";
		}
}