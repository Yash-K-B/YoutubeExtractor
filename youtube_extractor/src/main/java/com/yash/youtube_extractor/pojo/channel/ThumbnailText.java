package com.yash.youtube_extractor.pojo.channel;

import java.util.List;
import com.squareup.moshi.Json;

public class ThumbnailText{

	@Json(name = "runs")
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
			"ThumbnailText{" + 
			"runs = '" + runs + '\'' + 
			"}";
		}
}