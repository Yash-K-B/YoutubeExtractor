package com.yash.youtube_extractor.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class YoutubeChannelInfo {
    private Map<String, List<YoutubePlaylist>> playlistsByCategory = new HashMap<>();
    private String apiKey;
    private String clientVersion;
    private String visitorData;
}
