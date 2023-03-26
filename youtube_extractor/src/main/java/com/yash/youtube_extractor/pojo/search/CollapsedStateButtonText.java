package com.yash.youtube_extractor.pojo.search;

import java.util.List;
import com.squareup.moshi.Json;

public class CollapsedStateButtonText{

	@Json(name="accessibility")
	private Accessibility accessibility;

	@Json(name="runs")
	private List<RunsItem> runs;

	public void setAccessibility(Accessibility accessibility){
		this.accessibility = accessibility;
	}

	public Accessibility getAccessibility(){
		return accessibility;
	}

	public void setRuns(List<RunsItem> runs){
		this.runs = runs;
	}

	public List<RunsItem> getRuns(){
		return runs;
	}

	@Override
 	public String toString(){
		return 
			"CollapsedStateButtonText{" + 
			"accessibility = '" + accessibility + '\'' + 
			",runs = '" + runs + '\'' + 
			"}";
		}
}