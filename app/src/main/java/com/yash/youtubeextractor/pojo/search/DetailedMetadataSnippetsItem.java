package com.yash.youtubeextractor.pojo.search;

import lombok.Data;

@Data
public class DetailedMetadataSnippetsItem{
	private Boolean maxOneLine;
	private SnippetText snippetText;
	private SnippetHoverText snippetHoverText;
}