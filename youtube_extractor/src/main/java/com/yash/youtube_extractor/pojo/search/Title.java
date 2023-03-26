package com.yash.youtube_extractor.pojo.search;

import com.squareup.moshi.Json;

import java.util.List;

public class Title{

	@Json(name="accessibility")
	private Accessibility accessibility;

	@Json(name="runs")
	private List<RunsItem> runs;

	@Json(name="simpleText")
	private String simpleText;

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
			"accessibility = '" + accessibility + '\'' + 
			",runs = '" + runs + '\'' + 
			",simpleText = '" + simpleText + '\'' + 
			"}";
		}
}