package com.yash.youtube_extractor.pojo.search;

import com.squareup.moshi.Json;

public class WatchEndpointSupportedOnesieConfig{

	@Json(name="html5PlaybackOnesieConfig")
	private Html5PlaybackOnesieConfig html5PlaybackOnesieConfig;

	public void setHtml5PlaybackOnesieConfig(Html5PlaybackOnesieConfig html5PlaybackOnesieConfig){
		this.html5PlaybackOnesieConfig = html5PlaybackOnesieConfig;
	}

	public Html5PlaybackOnesieConfig getHtml5PlaybackOnesieConfig(){
		return html5PlaybackOnesieConfig;
	}

	@Override
 	public String toString(){
		return 
			"WatchEndpointSupportedOnesieConfig{" + 
			"html5PlaybackOnesieConfig = '" + html5PlaybackOnesieConfig + '\'' + 
			"}";
		}
}