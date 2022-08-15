package com.yash.youtube_extractor.pojo.search;

import java.util.List;
import com.squareup.moshi.Json;

public class SnippetText{

	@Json(name="runs")
	private List<RunsItem> runs;

	public void setRuns(List<RunsItem> runs){
		this.runs = runs;
	}

	public List<RunsItem> getRuns(){
		return runs;
	}

	@Override
 	public String toString(){
		return 
			"SnippetText{" + 
			"runs = '" + runs + '\'' + 
			"}";
		}
}