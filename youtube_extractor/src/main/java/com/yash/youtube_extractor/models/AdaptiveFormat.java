package com.yash.youtube_extractor.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.yash.youtube_extractor.models.StreamingData.ColorInfo;
import com.yash.youtube_extractor.models.StreamingData.IndexRange;
import com.yash.youtube_extractor.models.StreamingData.InitRange;

public class AdaptiveFormat {
    private static final String TAG = "AdaptiveFormat";

    @SerializedName("itag")
    @Expose
    private Integer itag;
    @SerializedName("mimeType")
    @Expose
    private String mimeType;
    @SerializedName("bitrate")
    @Expose
    private Integer bitrate;
    @SerializedName("width")
    @Expose
    private Integer width;
    @SerializedName("height")
    @Expose
    private Integer height;
    @SerializedName("initRange")
    @Expose
    private InitRange initRange;
    @SerializedName("indexRange")
    @Expose
    private IndexRange indexRange;
    @SerializedName("lastModified")
    @Expose
    private String lastModified;
    @SerializedName("contentLength")
    @Expose
    private long contentLength;
    @SerializedName("quality")
    @Expose
    private String quality;
    @SerializedName("fps")
    @Expose
    private Integer fps;
    @SerializedName("qualityLabel")
    @Expose
    private String qualityLabel;
    @SerializedName("projectionType")
    @Expose
    private String projectionType;
    @SerializedName("averageBitrate")
    @Expose
    private Integer averageBitrate;
    @SerializedName("approxDurationMs")
    @Expose
    private String approxDurationMs;
    @SerializedName("signatureCipher")
    @Expose
    private String signatureCipher;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("colorInfo")
    @Expose
    private ColorInfo colorInfo;
    @SerializedName("highReplication")
    @Expose
    private Boolean highReplication;
    @SerializedName("audioQuality")
    @Expose
    private String audioQuality;
    @SerializedName("audioSampleRate")
    @Expose
    private Integer audioSampleRate;
    @SerializedName("audioChannels")
    @Expose
    private Integer audioChannels;
    @SerializedName("loudnessDb")
    @Expose
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