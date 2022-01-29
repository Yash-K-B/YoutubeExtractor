package com.yash.youtubeextractor.pojo.search;

import java.util.List;
import lombok.Data;

@Data
public class Thumbnail{
	private List<ThumbnailsItem> thumbnails;
}