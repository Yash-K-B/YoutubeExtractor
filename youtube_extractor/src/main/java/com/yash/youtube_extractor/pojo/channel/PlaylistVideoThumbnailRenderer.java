package com.yash.youtube_extractor.pojo.channel;

import com.squareup.moshi.Json;
import com.yash.youtube_extractor.pojo.common.Thumbnail;

public class PlaylistVideoThumbnailRenderer{

	@Json(name = "thumbnail")
	private Thumbnail thumbnail;

	public void setThumbnail(Thumbnail thumbnail){
		this.thumbnail = thumbnail;
	}

	public Thumbnail getThumbnail(){
		return thumbnail;
	}

	@Override
 	public String toString(){
		return 
			"PlaylistVideoThumbnailRenderer{" + 
			"thumbnail = '" + thumbnail + '\'' + 
			"}";
		}
}