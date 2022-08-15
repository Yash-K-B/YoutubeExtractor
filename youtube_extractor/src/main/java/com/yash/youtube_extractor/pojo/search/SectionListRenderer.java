package com.yash.youtube_extractor.pojo.search;

import java.util.List;
import com.squareup.moshi.Json;

public class SectionListRenderer{

	@Json(name="contents")
	private List<SelectionListContentsItem> contents;

	public void setContents(List<SelectionListContentsItem> contents){
		this.contents = contents;
	}

	public List<SelectionListContentsItem> getContents(){
		return contents;
	}

	@Override
 	public String toString(){
		return 
			"SectionListRenderer{" + 
			"contents = '" + contents + '\'' + 
			"}";
		}
}