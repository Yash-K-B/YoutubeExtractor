package com.yash.youtube_extractor.pojo.playlist;

import com.squareup.moshi.Json;

public class VssLoggingContext{

	@Json(name="serializedContextData")
	private String serializedContextData;

	public void setSerializedContextData(String serializedContextData){
		this.serializedContextData = serializedContextData;
	}

	public String getSerializedContextData(){
		return serializedContextData;
	}

	@Override
 	public String toString(){
		return 
			"VssLoggingContext{" + 
			"serializedContextData = '" + serializedContextData + '\'' + 
			"}";
		}
}