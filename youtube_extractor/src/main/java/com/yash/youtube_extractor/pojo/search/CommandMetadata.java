package com.yash.youtube_extractor.pojo.search;

import com.squareup.moshi.Json;

public class CommandMetadata{

	@Json(name="webCommandMetadata")
	private WebCommandMetadata webCommandMetadata;

	public void setWebCommandMetadata(WebCommandMetadata webCommandMetadata){
		this.webCommandMetadata = webCommandMetadata;
	}

	public WebCommandMetadata getWebCommandMetadata(){
		return webCommandMetadata;
	}

	@Override
 	public String toString(){
		return 
			"CommandMetadata{" + 
			"webCommandMetadata = '" + webCommandMetadata + '\'' + 
			"}";
		}
}