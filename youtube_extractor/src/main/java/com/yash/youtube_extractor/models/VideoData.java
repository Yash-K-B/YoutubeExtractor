package com.yash.youtube_extractor.models;

import java.util.List;

import com.squareup.moshi.Json;

public class VideoData {

    @Json(name = "videoId")
    private String videoId;
    @Json(name = "title")
    private String title;
    @Json(name = "lengthSeconds")
    private String lengthSeconds;
    @Json(name="keywords")
    
    private List<String> keywords = null;
    @Json(name="channelId")
    
    private String channelId;
    @Json(name="isOwnerViewing")
    
    private Boolean isOwnerViewing;
    @Json(name="shortDescription")
    
    private String shortDescription;
    @Json(name="isCrawlable")
    
    private Boolean isCrawlable;
    @Json(name="thumbnail")
    
    private Thumbnail thumbnail;
    @Json(name="averageRating")
    
    private Double averageRating;
    @Json(name="allowRatings")
    
    private Boolean allowRatings;
    @Json(name="viewCount")
    
    private String viewCount;
    @Json(name="author")
    
    private String author;
    @Json(name="isPrivate")
    
    private Boolean isPrivate;
    @Json(name="isUnpluggedCorpus")
    
    private Boolean isUnpluggedCorpus;
    @Json(name="isLiveContent")
    
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

    @Override
    public String toString() {
        return "VideoData{" +
                "\nvideoId='" + videoId + '\'' +
                ", \ntitle='" + title + '\'' +
                ", \nlengthSeconds='" + lengthSeconds + '\'' +
                ", \nkeywords=" + keywords +
                ", \nchannelId='" + channelId + '\'' +
                ", \nisOwnerViewing=" + isOwnerViewing +
                ", \nshortDescription='" + shortDescription + '\'' +
                ", \nisCrawlable=" + isCrawlable +
                ", \nthumbnail=" + thumbnail +
                ", \naverageRating=" + averageRating +
                ", \nallowRatings=" + allowRatings +
                ", \nviewCount='" + viewCount + '\'' +
                ", \nauthor='" + author + '\'' +
                ", \nisPrivate=" + isPrivate +
                ", \nisUnpluggedCorpus=" + isUnpluggedCorpus +
                ", \nisLiveContent=" + isLiveContent +
                ", \nchannelThumbnail=" + channelThumbnail +
                "\n}";
    }

    public static class Thumbnail {

        @Json(name="thumbnails")
        
        private List<Thumbnail_> thumbnails = null;

        public List<Thumbnail_> getThumbnails() {
            return thumbnails;
        }

        public void setThumbnails(List<Thumbnail_> thumbnails) {
            this.thumbnails = thumbnails;
        }

    }


    public static class Thumbnail_ {

        @Json(name="url")
        
        private String url;
        @Json(name="width")
        
        private Integer width;
        @Json(name="height")
        
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