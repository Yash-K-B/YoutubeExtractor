package com.yash.youtube_extractor.pojo.search;

import com.google.gson.annotations.SerializedName;

public class WebCommandMetadata{

	@SerializedName("rootVe")
	private Integer rootVe;

	@SerializedName("webPageType")
	private String webPageType;

	@SerializedName("url")
	private String url;

	@SerializedName("apiUrl")
	private String apiUrl;

	@SerializedName("sendPost")
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