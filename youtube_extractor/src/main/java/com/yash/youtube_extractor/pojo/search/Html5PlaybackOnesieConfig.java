package com.yash.youtube_extractor.pojo.search;

import com.google.gson.annotations.SerializedName;

public class Html5PlaybackOnesieConfig{

	@SerializedName("commonConfig")
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