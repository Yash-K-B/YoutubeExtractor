package com.yash.youtube_extractor.models;

public class VideoDetails {
    private StreamingData streamingData;
    private VideoData videoData;

    public VideoDetails(StreamingData streamingData, VideoData videoData) {
        this.streamingData = streamingData;
        this.videoData = videoData;
    }

    public VideoData getVideoData() {
        return videoData;
    }

    public void setVideoData(VideoData videoData) {
        this.videoData = videoData;
    }

    public StreamingData getStreamingData() {
        return streamingData;
    }

    public void setStreamingData(StreamingData streamingData) {
        this.streamingData = streamingData;
    }
}
