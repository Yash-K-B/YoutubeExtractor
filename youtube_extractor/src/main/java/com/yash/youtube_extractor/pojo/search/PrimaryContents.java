package com.yash.youtube_extractor.pojo.search;

import com.google.gson.annotations.SerializedName;

public class PrimaryContents{

	@SerializedName("sectionListRenderer")
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