package com.yash.youtube_extractor.pojo.channel.lockup.model;

import java.util.List;
import lombok.Data;

@Data
public class Text{
	private String content;
	private List<StyleRunsItem> styleRuns;
}