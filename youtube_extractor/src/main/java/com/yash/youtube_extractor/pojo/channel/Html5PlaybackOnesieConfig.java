package com.yash.youtube_extractor.pojo.channel;

import com.squareup.moshi.Json;

public class Html5PlaybackOnesieConfig{

	@Json(name = "commonConfig")
	private CommonConfig commonConfig;

	public void setCommonConfig(CommonConfig commonConfig){
		this.commonConfig = commonConfig;
	}

	public CommonConfig getCommonConfig(){
		return commonConfig;
	}

	@Override
 	public String toString(){
		return 
			"Html5PlaybackOnesieConfig{" + 
			"commonConfig = '" + commonConfig + '\'' + 
			"}";
		}
}