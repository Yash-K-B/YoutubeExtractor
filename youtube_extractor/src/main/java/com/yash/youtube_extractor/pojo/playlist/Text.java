package com.yash.youtube_extractor.pojo.playlist;

import java.util.List;
import com.squareup.moshi.Json;

public class Text{

	@Json(name="runs")
	private List<RunsItem> runs;

	@Json(name="simpleText")
	private String simpleText;

	@Json(name="accessibility")
	private Accessibility accessibility;

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

	public void setAccessibility(Accessibility accessibility){
		this.accessibility = accessibility;
	}

	public Accessibility getAccessibility(){
		return accessibility;
	}

	@Override
 	public String toString(){
		return 
			"Text{" + 
			"runs = '" + runs + '\'' + 
			",simpleText = '" + simpleText + '\'' + 
			",accessibility = '" + accessibility + '\'' + 
			"}";
		}
}