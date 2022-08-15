package com.yash.youtube_extractor.models;


import com.squareup.moshi.Json;
import com.yash.youtube_extractor.models.StreamingData.ColorInfo;
import com.yash.youtube_extractor.models.StreamingData.IndexRange;
import com.yash.youtube_extractor.models.StreamingData.InitRange;

public class AdaptiveFormat {
    private static final String TAG = "AdaptiveFormat";

    @Json(name="itag")
    
    private Integer itag;
    @Json(name="mimeType")
    
    private String mimeType;
    @Json(name="bitrate")
    
    private Integer bitrate;
    @Json(name="width")
    
    private Integer width;
    @Json(name="height")
    
    private Integer height;
    @Json(name="initRange")
    
    private InitRange initRange;
    @Json(name="indexRange")
    
    private IndexRange indexRange;
    @Json(name="lastModified")
    
    private String lastModified;
    @Json(name="contentLength")
    
    private long contentLength;
    @Json(name="quality")
    
    private String quality;
    @Json(name="fps")
    
    private Integer fps;
    @Json(name="qualityLabel")
    
    private String qualityLabel;
    @Json(name="projectionType")
    
    private String projectionType;
    @Json(name="averageBitrate")
    
    private Integer averageBitrate;
    @Json(name="approxDurationMs")
    
    private String approxDurationMs;
    @Json(name="signatureCipher")
    
    private String signatureCipher;
    @Json(name="url")
    
    private String url;
    @Json(name="colorInfo")
    
    private ColorInfo colorInfo;
    @Json(name="highReplication")
    
    private Boolean highReplication;
    @Json(name="audioQuality")
    
    private String audioQuality;
    @Json(name="audioSampleRate")
    
    private Integer audioSampleRate;
    @Json(name="audioChannels")
    
    private Integer audioChannels;
    @Json(name="loudnessDb")
    
    private Double loudnessDb;

    public Integer getItag() {
        return itag;
    }

    public void setItag(Integer itag) {
        this.itag = itag;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public Integer getBitrate() {
        return bitrate;
    }

    public void setBitrate(Integer bitrate) {
        this.bitrate = bitrate;
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

    public InitRange getInitRange() {
        return initRange;
    }

    public void setInitRange(InitRange initRange) {
        this.initRange = initRange;
    }

    public IndexRange getIndexRange() {
        return indexRange;
    }

    public void setIndexRange(IndexRange indexRange) {
        this.indexRange = indexRange;
    }

    public String getLastModified() {
        return lastModified;
    }

    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }

    public long getContentLength() {
        return contentLength;
    }

    public void setContentLength(long contentLength) {
        this.contentLength = contentLength;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public Integer getFps() {
        return fps;
    }

    public void setFps(Integer fps) {
        this.fps = fps;
    }

    public String getQualityLabel() {
        return qualityLabel;
    }

    public void setQualityLabel(String qualityLabel) {
        this.qualityLabel = qualityLabel;
    }

    public String getProjectionType() {
        return projectionType;
    }

    public void setProjectionType(String projectionType) {
        this.projectionType = projectionType;
    }

    public Integer getAverageBitrate() {
        return averageBitrate;
    }

    public void setAverageBitrate(Integer averageBitrate) {
        this.averageBitrate = averageBitrate;
    }

    public String getApproxDurationMs() {
        return approxDurationMs;
    }

    public void setApproxDurationMs(String approxDurationMs) {
        this.approxDurationMs = approxDurationMs;
    }

    public String getSignatureCipher() {
        return signatureCipher;
    }

    public void setSignatureCipher(String signatureCipher) {
        this.signatureCipher = signatureCipher;
    }

    public ColorInfo getColorInfo() {
        return colorInfo;
    }

    public void setColorInfo(ColorInfo colorInfo) {
        this.colorInfo = colorInfo;
    }

    public Boolean getHighReplication() {
        return highReplication;
    }

    public void setHighReplication(Boolean highReplication) {
        this.highReplication = highReplication;
    }

    public String getAudioQuality() {
        return audioQuality;
    }

    public void setAudioQuality(String audioQuality) {
        this.audioQuality = audioQuality;
    }

    public Integer getAudioSampleRate() {
        return audioSampleRate;
    }

    public void setAudioSampleRate(Integer audioSampleRate) {
        this.audioSampleRate = audioSampleRate;
    }

    public Integer getAudioChannels() {
        return audioChannels;
    }

    public void setAudioChannels(Integer audioChannels) {
        this.audioChannels = audioChannels;
    }

    public Double getLoudnessDb() {
        return loudnessDb;
    }

    public void setLoudnessDb(Double loudnessDb) {
        this.loudnessDb = loudnessDb;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}