package com.yash.youtubeextractor.pojo.search;

import java.util.List;
import lombok.Data;

@Data
public class Title{
	private Accessibility accessibility;
	private List<RunsItem> runs;
	private String simpleText;
}