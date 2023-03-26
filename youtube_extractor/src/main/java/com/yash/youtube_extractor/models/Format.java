package com.yash.youtube_extractor.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Format {

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
    @SerializedName("lastModified")
    @Expose
    private String lastModified;
    @SerializedName("contentLength")
    @Expose
    private Long contentLength;
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
    @SerializedName("audioQuality")
    @Expose
    private String audioQuality;
    @SerializedName("approxDurationMs")
    @Expose
    private String approxDurationMs;
    @SerializedName("audioSampleRate")
    @Expose
    private Integer audioSampleRate;
    @SerializedName("audioChannels")
    @Expose
    private Integer audioChannels;
    @SerializedName("signatureCipher")
    @Expose
    private String signatureCipher;

    @SerializedName("url")
    @Expose
    private String url;

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

    public String getLastModified() {
        return lastModified;
    }

    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }

    public Long getContentLength() {
        return contentLength;
    }

    public void setContentLength(Long contentLength) {
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

    public String getAudioQuality() {
        return audioQuality;
    }

    public void setAudioQuality(String audioQuality) {
        this.audioQuality = audioQuality;
    }

    public String getApproxDurationMs() {
        return approxDurationMs;
    }

    public void setApproxDurationMs(String approxDurationMs) {
        this.approxDurationMs = approxDurationMs;
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

    public String getSignatureCipher() {
        return signatureCipher;
    }

    public void setSignatureCipher(String signatureCipher) {
        this.signatureCipher = signatureCipher;
    }

    public String getUrl() {
//        if(url == null)
//            url = StreamingData.cipherDecoder(signatureCipher);
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void decoder(StreamingData.Decoder decoder) {
        if (this.signatureCipher != null && decoder != null) {
            this.url = (StreamingData.cipherDecoder(this.signatureCipher, decoder));
        }
    }

    @Override
    public String toString() {
        return "Format{" +
                "itag=" + itag +
                ", mimeType='" + mimeType + '\'' +
                ", bitrate=" + bitrate +
                ", width=" + width +
                ", height=" + height +
                ", lastModified='" + lastModified + '\'' +
                ", contentLength='" + contentLength + '\'' +
                ", quality='" + quality + '\'' +
                ", fps=" + fps +
                ", qualityLabel='" + qualityLabel + '\'' +
                ", projectionType='" + projectionType + '\'' +
                ", averageBitrate=" + averageBitrate +
                ", audioQuality='" + audioQuality + '\'' +
                ", approxDurationMs='" + approxDurationMs + '\'' +
                ", audioSampleRate='" + audioSampleRate + '\'' +
                ", audioChannels=" + audioChannels +
                ", signatureCipher='" + signatureCipher + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}