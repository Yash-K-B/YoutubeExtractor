package com.yash.youtube_extractor.pojo.channel.lockup.model;

import java.util.List;
import lombok.Data;

@Data
public class ThumbnailViewModel{
	private Image image;
	private List<OverlaysItem> overlays;
}