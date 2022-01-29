package com.yash.youtubeextractor.pojo.search;

import java.util.List;
import lombok.Data;

@Data
public class CreatePlaylistServiceEndpoint{
	private String params;
	private List<String> videoIds;
}