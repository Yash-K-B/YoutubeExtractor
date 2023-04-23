package com.yash.youtube_extractor.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class YoutubeChannelInfo {
    private Map<String, List<YoutubePlaylist>> playlistsByCategory = new HashMap<>();
    private String apiKey;
    private String clientVersion;
    private String visitorData;

    public Map<String, List<YoutubePlaylist>> getPlaylistsByCategory() {
        return playlistsByCategory;
    }

    public void setPlaylistsByCategory(Map<String, List<YoutubePlaylist>> playlistsByCategory) {
        this.playlistsByCategory = playlistsByCategory;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getClientVersion() {
        return clientVersion;
    }

    public void setClientVersion(String clientVersion) {
        this.clientVersion = clientVersion;
    }

    public String getVisitorData() {
        return visitorData;
    }

    public void setVisitorData(String visitorData) {
        this.visitorData = visitorData;
    }
}
