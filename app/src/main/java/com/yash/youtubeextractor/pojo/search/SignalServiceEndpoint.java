package com.yash.youtubeextractor.pojo.search;

import java.util.List;
import lombok.Data;

@Data
public class SignalServiceEndpoint{
	private String signal;
	private List<ActionsItem> actions;
}