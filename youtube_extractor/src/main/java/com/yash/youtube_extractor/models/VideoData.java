package com.yash.youtube_extractor.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VideoData {

    @SerializedName("videoId")
    @Expose
    private String videoId;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("lengthSeconds")
    @Expose
    private String lengthSeconds;
    @SerializedName("keywords")
    @Expose
    private List<String> keywords = null;
    @SerializedName("channelId")
    @Expose
    private String channelId;
    @SerializedName("isOwnerViewing")
    @Expose
    private Boolean isOwnerViewing;
    @SerializedName("shortDescription")
    @Expose
    private String shortDescription;
    @SerializedName("isCrawlable")
    @Expose
    private Boolean isCrawlable;
    @SerializedName("thumbnail")
    @Expose
    private Thumbnail thumbnail;
    @SerializedName("averageRating")
    @Expose
    private Double averageRating;
    @SerializedName("allowRatings")
    @Expose
    private Boolean allowRatings;
    @SerializedName("viewCount")
    @Expose
    private String viewCount;
    @SerializedName("author")
    @Expose
    private String author;
    @SerializedName("isPrivate")
    @Expose
    private Boolean isPrivate;
    @SerializedName("isUnpluggedCorpus")
    @Expose
    private Boolean isUnpluggedCorpus;
    @SerializedName("isLiveContent")
    @Expose
    private Boolean isLiveContent;

    private ChannelThumbnail channelThumbnail;

    public ChannelThumbnail getChannelThumbnail() {
        return channelThumbnail;
    }

    public void setChannelThumbnail(ChannelThumbnail channelThumbnail) {
        this.channelThumbnail = channelThumbnail;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLengthSeconds() {
        return lengthSeconds;
    }

    public void setLengthSeconds(String lengthSeconds) {
        this.lengthSeconds = lengthSeconds;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public Boolean getIsOwnerViewing() {
        return isOwnerViewing;
    }

    public void setIsOwnerViewing(Boolean isOwnerViewing) {
        this.isOwnerViewing = isOwnerViewing;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public Boolean getIsCrawlable() {
        return isCrawlable;
    }

    public void setIsCrawlable(Boolean isCrawlable) {
        this.isCrawlable = isCrawlable;
    }

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(Double averageRating) {
        this.averageRating = averageRating;
    }

    public Boolean getAllowRatings() {
        return allowRatings;
    }

    public void setAllowRatings(Boolean allowRatings) {
        this.allowRatings = allowRatings;
    }

    public String getViewCount() {
        return viewCount;
    }

    public void setViewCount(String viewCount) {
        this.viewCount = viewCount;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Boolean getIsPrivate() {
        return isPrivate;
    }

    public void setIsPrivate(Boolean isPrivate) {
        this.isPrivate = isPrivate;
    }

    public Boolean getIsUnpluggedCorpus() {
        return isUnpluggedCorpus;
    }

    public void setIsUnpluggedCorpus(Boolean isUnpluggedCorpus) {
        this.isUnpluggedCorpus = isUnpluggedCorpus;
    }

    public Boolean getIsLiveContent() {
        return isLiveContent;
    }

    public void setIsLiveContent(Boolean isLiveContent) {
        this.isLiveContent = isLiveContent;
    }


    public static class Thumbnail {

        @SerializedName("thumbnails")
        @Expose
        private List<Thumbnail_> thumbnails = null;

        public List<Thumbnail_> getThumbnails() {
            return thumbnails;
        }

        public void setThumbnails(List<Thumbnail_> thumbnails) {
            this.thumbnails = thumbnails;
        }

    }


    public static class Thumbnail_ {

        @SerializedName("url")
        @Expose
        private String url;
        @SerializedName("width")
        @Expose
        private Integer width;
        @SerializedName("height")
        @Expose
        private Integer height;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public Integer getWidth() {
            return width;
        }

        public void setWidth(Integer width) {
            this.width = width;
        }

        public Integer getHeight() {
            return height;
        }

        public void setHeight(Integer height) {
            this.height = height;
        }

    }

}