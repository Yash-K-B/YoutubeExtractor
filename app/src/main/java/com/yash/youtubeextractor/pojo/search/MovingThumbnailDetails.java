package com.yash.youtubeextractor.pojo.search;

import java.util.List;
import lombok.Data;

@Data
public class MovingThumbnailDetails{
	private Boolean logAsMovingThumbnail;
	private List<ThumbnailsItem> thumbnails;
}