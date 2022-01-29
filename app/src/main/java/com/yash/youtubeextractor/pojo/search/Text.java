package com.yash.youtubeextractor.pojo.search;

import java.util.List;
import lombok.Data;

@Data
public class Text{
	private List<RunsItem> runs;
	private String simpleText;
	private Accessibility accessibility;
}