package com.yash.youtube_extractor.pojo.search;

import com.squareup.moshi.Json;

public class PrimaryContents{

	@Json(name="sectionListRenderer")
	private SectionListRenderer sectionListRenderer;

	public void setSectionListRenderer(SectionListRenderer sectionListRenderer){
		this.sectionListRenderer = sectionListRenderer;
	}

	public SectionListRenderer getSectionListRenderer(){
		return sectionListRenderer;
	}

	@Override
 	public String toString(){
		return 
			"PrimaryContents{" + 
			"sectionListRenderer = '" + sectionListRenderer + '\'' + 
			"}";
		}
}