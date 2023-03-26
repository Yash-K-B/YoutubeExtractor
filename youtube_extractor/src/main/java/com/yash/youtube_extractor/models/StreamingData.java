package com.yash.youtube_extractor.models;

import android.net.Uri;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class StreamingData implements Serializable {


    boolean isFormatInitialized = false;
    @SerializedName("expiresInSeconds")
    private String expiresInSeconds;
    @SerializedName("formats")
    @Expose
    private List<Format> formats = null;
    @SerializedName("adaptiveFormats")
    @Expose
    private List<AdaptiveFormat> adaptiveFormats = null;

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

    public void getMuxedStreamFormats(List<Format> formats) {
        this.formats = formats;
    }

    public List<AdaptiveFormat> getAdaptiveFormats() {
        return adaptiveFormats;
    }

    public void setAdaptiveFormats(List<AdaptiveFormat> adaptiveFormats) {
        this.adaptiveFormats = adaptiveFormats;
    }

    public List<AdaptiveAudioFormat> getAdaptiveAudioFormats() {
        //initFormats();
        return adaptiveAudioFormats;
    }

    public void setAdaptiveAudioFormats(List<AdaptiveAudioFormat> adaptiveAudioFormats) {
        this.adaptiveAudioFormats = adaptiveAudioFormats;
    }

    public List<AdaptiveVideoFormat> getAdaptiveVideoFormats() {
        //initFormats();
        return adaptiveVideoFormats;
    }

    public void setAdaptiveVideoFormats(List<AdaptiveVideoFormat> adaptiveVideoFormats) {
        this.adaptiveVideoFormats = adaptiveVideoFormats;
    }

//    private void initFormats() {
//        if (adaptiveFormats == null) return;
//        if (isFormatInitialized) return;
//        for (int i = 0; i < adaptiveFormats.size(); i++) {
//            if (adaptiveFormats.get(i).getHeight() == null)
//                adaptiveAudioFormats.add(new AdaptiveAudioFormat(adaptiveFormats.get(i)));
//            else adaptiveVideoFormats.add(new AdaptiveVideoFormat(adaptiveFormats.get(i)));
//        }
//        isFormatInitialized = true;
//    }

    public static class ColorInfo {

        @SerializedName("primaries")
        @Expose
        private String primaries;
        @SerializedName("transferCharacteristics")
        @Expose
        private String transferCharacteristics;
        @SerializedName("matrixCoefficients")
        @Expose
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

        @SerializedName("start")
        @Expose
        private String start;
        @SerializedName("end")
        @Expose
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

        @SerializedName("start")
        @Expose
        private String start;
        @SerializedName("end")
        @Expose
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

        public AdaptiveAudioFormat() {
        }

        public AdaptiveAudioFormat(AdaptiveFormat format, Decoder decoder) {
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
            this.url = format.getUrl() == null ? StreamingData.cipherDecoder(format.getSignatureCipher(), decoder) : format.getUrl();
        }

        @SerializedName("itag")
        @Expose
        private Integer itag;
        @SerializedName("mimeType")
        @Expose
        private String mimeType;
        @SerializedName("bitrate")
        @Expose
        private Integer bitrate;
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
        private Long contentLength;
        @SerializedName("quality")
        @Expose
        private String quality;
        @SerializedName("projectionType")
        @Expose
        private String projectionType;
        @SerializedName("averageBitrate")
        @Expose
        private Integer averageBitrate;
        @SerializedName("highReplication")
        @Expose
        private Boolean highReplication;
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
        @SerializedName("loudnessDb")
        @Expose
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

        public AdaptiveVideoFormat() {
        }

        public AdaptiveVideoFormat(AdaptiveFormat format, Decoder decoder) {
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
            this.url = format.getUrl() == null ? StreamingData.cipherDecoder(format.getSignatureCipher(), decoder) : format.getUrl();
        }

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
        @SerializedName("approxDurationMs")
        @Expose
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
                adaptiveAudioFormats.add(new AdaptiveAudioFormat(adaptiveFormats.get(i), decoder));
            else adaptiveVideoFormats.add(new AdaptiveVideoFormat(adaptiveFormats.get(i), decoder));
        }
        for (int i = 0; i < formats.size(); i++)
            formats.get(i).decoder(decoder);
        isFormatInitialized = true;
    }

    public static String cipherDecoder(String encodedCipher, Decoder decoder) {
        if (decoder == null) return "";
        Map<String, String> queryParams = new HashMap<>();
        for (String param : encodedCipher.split("&", 3)) {
            String[] splits = param.split("=", 2);
            queryParams.put(splits[0], splits.length > 1 ? splits[splits.length - 1] : "");
        }
        String encodedUrl = queryParams.get("url");
        if(encodedUrl == null)
            return null;
        String url = Uri.decode(encodedUrl.replace("\\/", "/"));
        String paramKey = Uri.decode(queryParams.get("sp"));
        String signature = Uri.decode(queryParams.get("s"));
        return String.format(Locale.US, "%s&%s=%s", url, paramKey, Uri.encode(decoder.decode(signature)));
    }


    //regex player js = /s/player/([A-za-z0-9_]+)/player_ias.vflset/en_US/base.js

    /*  Decoder Function */
    private static String decode(String str) {


        StringBuilder builder = new StringBuilder(str);
        //set1
//        Eu(builder, 29);
//        oG(builder, 9);
//        Eu(builder, 38);
//        oG(builder, 66);
        //set2 version = 4a1799bd
        //regex = ([A-za-z0-9_]+)\s*=\s*function\(\s*a\s*\)\{\s*a\s*=\s*a.split\(\"\"\);.*a.join\(\"\"\)\};
        by(builder, 2);
        Eu(builder, 30);
        oG(builder, 36);
        Context context = Context.enter();
        Scriptable scope = context.initStandardObjects();

        return builder.toString();
    }


    private static void oG(StringBuilder builder, int b) {
        builder.reverse();
    }

    private static void Eu(StringBuilder builder, int b) {
        char c = builder.charAt(0);
        builder.setCharAt(0, builder.charAt(b % builder.length()));
        builder.setCharAt(b % builder.length(), c);
    }

    private static void by(StringBuilder builder, int b) {
        builder.delete(0, b);
    }

    @NonNull
    @Override
    public String toString() {
        //initFormats();
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

    public interface Decoder {
        public String decode(String signature);
    }
}