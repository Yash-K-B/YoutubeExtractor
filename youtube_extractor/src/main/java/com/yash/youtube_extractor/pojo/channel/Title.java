package com.yash.youtube_extractor.pojo.channel;

import java.util.List;
import com.squareup.moshi.Json;

public class Title{

	@Json(name = "runs")
	private List<RunsItem> runs;

	@Json(name = "simpleText")
	private String simpleText;

	public void setRuns(List<RunsItem> runs){
		this.runs = runs;
	}

	public List<RunsItem> getRuns(){
		return runs;
	}

	public void setSimpleText(String simpleText){
		this.simpleText = simpleText;
	}

	public String getSimpleText(){
		return simpleText;
	}

	@Override
 	public String toString(){
		return 
			"Title{" + 
			"runs = '" + runs + '\'' + 
			",simpleText = '" + simpleText + '\'' + 
			"}";
		}
}