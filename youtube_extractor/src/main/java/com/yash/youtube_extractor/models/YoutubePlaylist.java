package com.yash.youtube_extractor.models;

import lombok.Data;

@Data
public class YoutubePlaylist {
    private String playlistId;
    private String title;
    private String description;
    private String videoCount;
    private String artUrlSmall, artUrlMedium, artUrlHigh;
}
