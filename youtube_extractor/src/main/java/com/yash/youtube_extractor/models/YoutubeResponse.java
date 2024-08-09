package com.yash.youtube_extractor.models;

import com.yash.youtube_extractor.constants.ContinuationType;

import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
public class YoutubeResponse {
    private final List<YoutubeSong> songs;
    private final String continuationToken;
    private final ContinuationType continuationType;

    public YoutubeResponse(List<YoutubeSong> songs, String continuationToken, String continuationType) {
        this.songs = songs;
        this.continuationToken = continuationToken;
        this.continuationType = StringUtils.isNotBlank(continuationType) && continuationType.contains("BROWSE") ? ContinuationType.BROWSE : ContinuationType.NEXT;
    }

    public static YoutubeResponse empty() {
        return new YoutubeResponse(new ArrayList<>(), null, null);
    }
}
