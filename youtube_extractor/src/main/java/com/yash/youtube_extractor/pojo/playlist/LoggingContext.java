package com.yash.youtube_extractor.pojo.playlist;

import com.squareup.moshi.Json;

public class LoggingContext{

	@Json(name="vssLoggingContext")
	private VssLoggingContext vssLoggingContext;

	public void setVssLoggingContext(VssLoggingContext vssLoggingContext){
		this.vssLoggingContext = vssLoggingContext;
	}

	public VssLoggingContext getVssLoggingContext(){
		return vssLoggingContext;
	}

	@Override
 	public String toString(){
		return 
			"LoggingContext{" + 
			"vssLoggingContext = '" + vssLoggingContext + '\'' + 
			"}";
		}
}