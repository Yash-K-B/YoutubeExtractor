package com.yash.youtube_extractor.pojo.playlist;

import com.squareup.moshi.Json;

public class ThumbnailOverlayResumePlaybackRenderer{

	@Json(name="percentDurationWatched")
	private Integer percentDurationWatched;

	public void setPercentDurationWatched(Integer percentDurationWatched){
		this.percentDurationWatched = percentDurationWatched;
	}

	public Integer getPercentDurationWatched(){
		return percentDurationWatched;
	}

	@Override
 	public String toString(){
		return 
			"ThumbnailOverlayResumePlaybackRenderer{" + 
			"percentDurationWatched = '" + percentDurationWatched + '\'' + 
			"}";
		}
}