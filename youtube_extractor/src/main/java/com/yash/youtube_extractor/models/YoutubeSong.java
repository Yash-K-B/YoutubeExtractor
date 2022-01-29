package com.yash.youtube_extractor.models;

public class YoutubeSong {
    String title,videoId,channelTitle,channelDesc;
    String artUrlSmall,artUrlMedium;
    long durationMillis;
    String view;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getChannelTitle() {
        return channelTitle;
    }

    public void setChannelTitle(String channelTitle) {
        this.channelTitle = channelTitle;
    }

    public String getChannelDesc() {
        return channelDesc;
    }

    public void setChannelDesc(String channelDesc) {
        this.channelDesc = channelDesc;
    }

    public String getArtUrlSmall() {
        return artUrlSmall;
    }

    public void setArtUrlSmall(String artUrlSmall) {
        this.artUrlSmall = artUrlSmall;
    }

    public String getArtUrlMedium() {
        return artUrlMedium;
    }

    public void setArtUrlMedium(String artUrlMedium) {
        this.artUrlMedium = artUrlMedium;
    }

    public long getDurationMillis() {
        return durationMillis;
    }

    public void setDurationMillis(long durationMillis) {
        this.durationMillis = durationMillis;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    @Override
    public String toString() {
        return "YoutubeSong{" +
                "title='" + title + '\'' +
                ", videoId='" + videoId + '\'' +
                ", channelTitle='" + channelTitle + '\'' +
                ", channelDesc='" + channelDesc + '\'' +
                ", artUrlSmall='" + artUrlSmall + '\'' +
                ", artUrlMedium='" + artUrlMedium + '\'' +
                ", durationMillis=" + durationMillis +
                ", view='" + view + '\'' +
                '}';
    }
}
