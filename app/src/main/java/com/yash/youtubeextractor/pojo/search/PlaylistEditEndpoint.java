package com.yash.youtubeextractor.pojo.search;

import java.util.List;
import lombok.Data;

@Data
public class PlaylistEditEndpoint{
	private String playlistId;
	private List<ActionsItem> actions;
}