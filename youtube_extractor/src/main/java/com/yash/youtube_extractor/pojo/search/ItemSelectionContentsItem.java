package com.yash.youtube_extractor.pojo.search;

import com.google.gson.annotations.SerializedName;

public class ItemSelectionContentsItem {
    @SerializedName("videoRenderer")
    private VideoRenderer videoRenderer;

    @SerializedName("shelfRenderer")
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
