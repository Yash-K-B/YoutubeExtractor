package com.yash.youtube_extractor.pojo.search;

import com.squareup.moshi.Json;

public class ItemSelectionContentsItem {
    @Json(name="videoRenderer")
    private VideoRenderer videoRenderer;

    @Json(name="shelfRenderer")
    private ShelfRenderer shelfRenderer;

    public VideoRenderer getVideoRenderer() {
        return videoRenderer;
    }

    public void setVideoRenderer(VideoRenderer videoRenderer) {
        this.videoRenderer = videoRenderer;
    }

    public ShelfRenderer getShelfRenderer() {
        return shelfRenderer;
    }

    public void setShelfRenderer(ShelfRenderer shelfRenderer) {
        this.shelfRenderer = shelfRenderer;
    }

    @Override
    public String toString() {
        return "ItemSelectionContentsItem{" +
                "videoRenderer=" + videoRenderer +
                ", shelfRenderer=" + shelfRenderer +
                '}';
    }
}
