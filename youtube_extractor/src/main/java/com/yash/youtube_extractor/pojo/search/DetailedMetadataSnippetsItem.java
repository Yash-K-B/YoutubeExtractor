package com.yash.youtube_extractor.pojo.search;

import com.squareup.moshi.Json;

public class DetailedMetadataSnippetsItem{

	@Json(name="maxOneLine")
	private Boolean maxOneLine;

	@Json(name="snippetText")
	private SnippetText snippetText;

	@Json(name="snippetHoverText")
	private SnippetHoverText snippetHoverText;

	public void setMaxOneLine(Boolean maxOneLine){
		this.maxOneLine = maxOneLine;
	}

	public Boolean isMaxOneLine(){
		return maxOneLine;
	}

	public void setSnippetText(SnippetText snippetText){
		this.snippetText = snippetText;
	}

	public SnippetText getSnippetText(){
		return snippetText;
	}

	public void setSnippetHoverText(SnippetHoverText snippetHoverText){
		this.snippetHoverText = snippetHoverText;
	}

	public SnippetHoverText getSnippetHoverText(){
		return snippetHoverText;
	}

	@Override
 	public String toString(){
		return 
			"DetailedMetadataSnippetsItem{" + 
			"maxOneLine = '" + maxOneLine + '\'' + 
			",snippetText = '" + snippetText + '\'' + 
			",snippetHoverText = '" + snippetHoverText + '\'' + 
			"}";
		}
}