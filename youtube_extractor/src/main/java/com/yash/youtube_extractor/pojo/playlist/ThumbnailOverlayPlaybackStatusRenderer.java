package com.yash.youtube_extractor.pojo.playlist;

import java.util.List;
import com.squareup.moshi.Json;

public class ThumbnailOverlayPlaybackStatusRenderer{

	@Json(name="texts")
	private List<TextsItem> texts;

	public void setTexts(List<TextsItem> texts){
		this.texts = texts;
	}

	public List<TextsItem> getTexts(){
		return texts;
	}

	@Override
 	public String toString(){
		return 
			"ThumbnailOverlayPlaybackStatusRenderer{" + 
			"texts = '" + texts + '\'' + 
			"}";
		}
}