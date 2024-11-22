package com.yash.youtube_extractor.pojo.channel.lockup.model;

import java.util.List;
import lombok.Data;

@Data
public class ContentMetadataViewModel{
	private String delimiter;
	private List<MetadataRowsItem> metadataRows;
}