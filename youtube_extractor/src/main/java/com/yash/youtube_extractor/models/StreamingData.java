package com.yash.youtube_extractor.models;

import android.util.Log;

import androidx.annotation.NonNull;

import com.squareup.moshi.Json;
import com.yash.youtube_extractor.utility.DecoderUtility;
import com.yash.youtube_extractor.utility.UrlUtility;

import org.apache.commons.lang.StringUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class StreamingData implements Serializable {

    private static final String TAG = "StreamingData";


    boolean isFormatInitialized = false;
    @Json(name = "expiresInSeconds")
    private String expiresInSeconds;
    @Json(name = "formats")
    private List<Format> formats = new ArrayList<>();
    @Json(name = "adaptiveFormats")
    private List<AdaptiveFormat> adaptiveFormats = new ArrayList<>();

    @Json(name = "serverAbrStreamingUrl")
    private String serverAbrStreamingUrl;

    private List<AdaptiveAudioFormat> adaptiveAudioFormats = new ArrayList<>();

    private List<AdaptiveVideoFormat> adaptiveVideoFormats = new ArrayList<>();

    public String getExpiresInSeconds() {
        return expiresInSeconds;
    }

    public void setExpiresInSeconds(String expiresInSeconds) {
        this.expiresInSeconds = expiresInSeconds;
    }

    public List<Format> getMuxedStreamFormats() {
        return formats;
    }

    public void setMuxedStreamFormats(List<Format> formats) {
        this.formats = formats;
    }

    public void setAdaptiveFormats(List<AdaptiveFormat> adaptiveFormats) {
        this.adaptiveFormats = adaptiveFormats;
    }

    public List<AdaptiveAudioFormat> getAdaptiveAudioFormats() {
        return adaptiveAudioFormats;
    }

    public void setAdaptiveAudioFormats(List<AdaptiveAudioFormat> adaptiveAudioFormats) {
        this.adaptiveAudioFormats = adaptiveAudioFormats;
    }

    public List<AdaptiveVideoFormat> getAdaptiveVideoFormats() {
        return adaptiveVideoFormats;
    }

    public void setAdaptiveVideoFormats(List<AdaptiveVideoFormat> adaptiveVideoFormats) {
        this.adaptiveVideoFormats = adaptiveVideoFormats;
    }

    public String getServerAbrStreamingUrl() {
        return serverAbrStreamingUrl;
    }

    public void setServerAbrStreamingUrl(String serverAbrStreamingUrl) {
        this.serverAbrStreamingUrl = serverAbrStreamingUrl;
    }

    public static class ColorInfo {

        @Json(name = "primaries")
        private String primaries;
        @Json(name = "transferCharacteristics")
        private String transferCharacteristics;
        @Json(name = "matrixCoefficients")
        private String matrixCoefficients;

        public String getPrimaries() {
            return primaries;
        }

        public void setPrimaries(String primaries) {
            this.primaries = primaries;
        }

        public String getTransferCharacteristics() {
            return transferCharacteristics;
        }

        public void setTransferCharacteristics(String transferCharacteristics) {
            this.transferCharacteristics = transferCharacteristics;
        }

        public String getMatrixCoefficients() {
            return matrixCoefficients;
        }

        public void setMatrixCoefficients(String matrixCoefficients) {
            this.matrixCoefficients = matrixCoefficients;
        }

    }

    public static class IndexRange {

        @Json(name = "start")
        private String start;
        @Json(name = "end")
        private String end;

        public String getStart() {
            return start;
        }

        public void setStart(String start) {
            this.start = start;
        }

        public String getEnd() {
            return end;
        }

        public void setEnd(String end) {
            this.end = end;
        }

    }

    public static class InitRange {

        @Json(name="start")
        private String start;
        @Json(name="end")
        private String end;

        public String getStart() {
            return start;
        }

        public void setStart(String start) {
            this.start = start;
        }

        public String getEnd() {
            return end;
        }

        public void setEnd(String end) {
            this.end = end;
        }

    }

    public static class AdaptiveAudioFormat {

        public AdaptiveAudioFormat(AdaptiveFormat format, Decoder decoder, String serverAbrStreamingUrl) {
            this.itag = format.getItag();
            this.mimeType = format.getMimeType();
            this.bitrate = format.getBitrate();
            this.initRange = format.getInitRange();
            this.indexRange = format.getIndexRange();
            this.lastModified = format.getLastModified();
            this.contentLength = format.getContentLength();
            this.quality = format.getQuality();
            this.projectionType = format.getProjectionType();
            this.averageBitrate = format.getAverageBitrate();
            this.highReplication = format.getHighReplication();
            this.audioQuality = format.getAudioQuality();
            this.approxDurationMs = format.getApproxDurationMs();
            this.audioSampleRate = format.getAudioSampleRate();
            this.audioChannels = format.getAudioChannels();
            this.loudnessDb = format.getLoudnessDb();
            if (StringUtils.isNotBlank(format.getUrl()) || StringUtils.isNotBlank(format.getSignatureCipher())) {
                this.url = DecoderUtility.getUrl(format.getUrl(), format.getSignatureCipher(), decoder);
            } else {
                this.url = DecoderUtility.getUrl(UrlUtility.buildUrl(format, serverAbrStreamingUrl), format.getSignatureCipher(), decoder);;
            }
        }

        @Json(name="itag")
        private Integer itag;
        @Json(name="mimeType")
        private String mimeType;
        @Json(name="bitrate")
        private Integer bitrate;
        @Json(name="initRange")
        private InitRange initRange;
        @Json(name="indexRange")
        private IndexRange indexRange;
        @Json(name="lastModified")
        private String lastModified;
        @Json(name="contentLength")
        private Long contentLength;
        @Json(name="quality")
        private String quality;
        @Json(name="projectionType")
        private String projectionType;
        @Json(name="averageBitrate")
        private Integer averageBitrate;
        @Json(name="highReplication")
        private Boolean highReplication;
        @Json(name="audioQuality")
        private String audioQuality;
        @Json(name="approxDurationMs")
        private String approxDurationMs;
        @Json(name="audioSampleRate")
        private Integer audioSampleRate;
        @Json(name="audioChannels")
        private Integer audioChannels;
        @Json(name="loudnessDb")
        private Double loudnessDb;

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

        @NonNull
        @Override
        public String toString() {
            return "AdaptiveAudioFormat{" +
                    "itag=" + itag +
                    ", mimeType='" + mimeType + '\'' +
                    ", bitrate=" + bitrate +
                    ", initRange=" + initRange +
                    ", indexRange=" + indexRange +
                    ", lastModified='" + lastModified + '\'' +
                    ", contentLength='" + contentLength + '\'' +
                    ", quality='" + quality + '\'' +
                    ", projectionType='" + projectionType + '\'' +
                    ", averageBitrate=" + averageBitrate +
                    ", highReplication=" + highReplication +
                    ", audioQuality='" + audioQuality + '\'' +
                    ", approxDurationMs='" + approxDurationMs + '\'' +
                    ", audioSampleRate='" + audioSampleRate + '\'' +
                    ", audioChannels=" + audioChannels +
                    ", loudnessDb=" + loudnessDb +
                    ", url='" + url + '\'' +
                    '}';
        }
    }

    public static class AdaptiveVideoFormat {

        public AdaptiveVideoFormat(AdaptiveFormat format, Decoder decoder, String serverAbrStreamingUrl) {
            this.itag = format.getItag();
            this.mimeType = format.getMimeType();
            this.bitrate = format.getBitrate();
            this.width = format.getWidth();
            this.height = format.getHeight();
            this.initRange = format.getInitRange();
            this.indexRange = format.getIndexRange();
            this.lastModified = format.getLastModified();
            this.contentLength = format.getContentLength();
            this.quality = format.getQuality();
            this.fps = format.getFps();
            this.qualityLabel = format.getQualityLabel();
            this.projectionType = format.getProjectionType();
            this.averageBitrate = format.getAverageBitrate();
            this.approxDurationMs = format.getApproxDurationMs();
            if (StringUtils.isNotBlank(format.getUrl()) || StringUtils.isNotBlank(format.getSignatureCipher())) {
                this.url = DecoderUtility.getUrl(format.getUrl(), format.getSignatureCipher(), decoder);
            } else {
                this.url = DecoderUtility.getUrl(UrlUtility.buildUrl(format, serverAbrStreamingUrl), format.getSignatureCipher(), decoder);
            }
        }

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
        @Json(name="approxDurationMs")
        private String approxDurationMs;

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

        public String getApproxDurationMs() {
            return approxDurationMs;
        }

        public void setApproxDurationMs(String approxDurationMs) {
            this.approxDurationMs = approxDurationMs;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        @NonNull
        @Override
        public String toString() {
            return "AdaptiveVideoFormat{" +
                    "itag=" + itag +
                    ", mimeType='" + mimeType + '\'' +
                    ", bitrate=" + bitrate +
                    ", width=" + width +
                    ", height=" + height +
                    ", initRange=" + initRange +
                    ", indexRange=" + indexRange +
                    ", lastModified='" + lastModified + '\'' +
                    ", contentLength='" + contentLength + '\'' +
                    ", quality='" + quality + '\'' +
                    ", fps=" + fps +
                    ", qualityLabel='" + qualityLabel + '\'' +
                    ", projectionType='" + projectionType + '\'' +
                    ", averageBitrate=" + averageBitrate +
                    ", approxDurationMs='" + approxDurationMs + '\'' +
                    ", url='" + url + '\'' +
                    '}';
        }
    }


    public void initObject(Decoder decoder) {
        if (adaptiveFormats == null) return;
        if (isFormatInitialized) return;
        for (int i = 0; i < adaptiveFormats.size(); i++) {
            if (adaptiveFormats.get(i).getHeight() == null)
                adaptiveAudioFormats.add(new AdaptiveAudioFormat(adaptiveFormats.get(i), decoder, serverAbrStreamingUrl));
            else adaptiveVideoFormats.add(new AdaptiveVideoFormat(adaptiveFormats.get(i), decoder, serverAbrStreamingUrl));
        }
        for (int i = 0; i < formats.size(); i++)
            formats.get(i).decoder(decoder);
        isFormatInitialized = true;
    }

    @NonNull
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("AdaptiveAudioFormat : \n\n");
        for (AdaptiveAudioFormat audioFormat : adaptiveAudioFormats) {
            builder.append(audioFormat.toString()).append("\n\n");
        }
        builder.append("AdaptiveVideoFormat : \n\n");
        for (AdaptiveVideoFormat videoFormat : adaptiveVideoFormats) {
            builder.append(videoFormat.toString()).append("\n\n");
        }
        builder.append("MuxedFormats : \n\n");
        for (Format format : formats) {
            builder.append(format.toString()).append("\n\n");
        }

        return "\nisFormatInitialized=" + isFormatInitialized +
                ", \nexpiresInSeconds='" + expiresInSeconds + '\'' +
                builder.toString();
    }

}