package com.yash.youtube_extractor.models;


import com.squareup.moshi.Json;
import com.yash.youtube_extractor.utility.DecoderUtility;

public class Format {

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
    @Json(name="lastModified")
    
    private String lastModified;
    @Json(name="contentLength")
    
    private Long contentLength;
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
    @Json(name="audioQuality")
    
    private String audioQuality;
    @Json(name="approxDurationMs")
    
    private String approxDurationMs;
    @Json(name="audioSampleRate")
    
    private Integer audioSampleRate;
    @Json(name="audioChannels")
    
    private Integer audioChannels;
    @Json(name="signatureCipher")
    
    private String signatureCipher;

    @Json(name="url")
    
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

    public void decoder(Decoder decoder) {
        this.url = DecoderUtility.getUrl(this.url, this.signatureCipher, decoder);
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