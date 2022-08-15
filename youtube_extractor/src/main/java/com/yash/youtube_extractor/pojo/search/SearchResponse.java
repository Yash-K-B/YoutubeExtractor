package com.yash.youtube_extractor.pojo.search;

import com.squareup.moshi.Json;

public class SearchResponse{

	@Json(name="primaryContents")
	private PrimaryContents primaryContents;

	public void setPrimaryContents(PrimaryContents primaryContents){
		this.primaryContents = primaryContents;
	}

	public PrimaryContents getPrimaryContents(){
		return primaryContents;
	}

	@Override
 	public String toString(){
		return 
			"SearchResponse{" + 
			"primaryContents = '" + primaryContents + '\'' + 
			"}";
		}
}