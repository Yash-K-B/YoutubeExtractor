package com.yash.youtubeextractor.pojo.search;

import java.util.List;
import lombok.Data;

@Data
public class AddToPlaylistCommand{
	private OnCreateListCommand onCreateListCommand;
	private String videoId;
	private Boolean openMiniplayer;
	private String listType;
	private List<String> videoIds;
}