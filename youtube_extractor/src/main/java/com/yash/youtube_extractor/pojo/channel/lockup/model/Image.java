package com.yash.youtube_extractor.pojo.channel.lockup.model;

import com.yash.youtube_extractor.pojo.common.ThumbnailsItem;

import java.util.List;
import lombok.Data;

@Data
public class Image{
	private List<ThumbnailsItem> sources;
}