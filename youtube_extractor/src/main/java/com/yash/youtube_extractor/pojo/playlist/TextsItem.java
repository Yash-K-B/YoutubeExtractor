package com.yash.youtube_extractor.pojo.playlist;

import java.util.List;
import com.squareup.moshi.Json;

public class TextsItem{

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
			"TextsItem{" + 
			"runs = '" + runs + '\'' + 
			"}";
		}
}