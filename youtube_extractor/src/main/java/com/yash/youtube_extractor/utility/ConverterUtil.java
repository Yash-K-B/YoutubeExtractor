package com.yash.youtube_extractor.utility;

import java.text.DecimalFormat;
import java.util.Locale;

public class ConverterUtil {
    private static DecimalFormat df = new DecimalFormat("0.0");

    public static String convertToHighest(long value) {
        if (value >= 1073741824)
            return df.format(value / 1073741824.0) + "GB";
        else if (value >= 1048576)
            return df.format(value / 1048576.0) + "MB";
        else if (value >= 1024)
            return df.format(value / 1024.0) + "KB";
        else return value + "B";
    }

    public static String getBitrate(int bitrate) {
        if (bitrate >= 1000000)
            return bitrate / 1000000 + "Mbps";
        else if (bitrate >= 1000)
            return bitrate / 1000 + "Kbps";
        else return bitrate + "bps";
    }

    public static String getSampleRate(Integer sampleRate) {
        if (sampleRate % 1000 == 0) return sampleRate / 1000 + "KHz";
        else return df.format(sampleRate / 1000.0) + "KHz";
    }

    public static String getFrameRate(Integer fps){
        return fps+"FPS";
    }

    public static String formatDuration(long millis) {
        long seconds = millis / 1000;
        long minutes = seconds / 60;
        long hours = minutes / 60;
        long days = hours / 24;

        if (days > 0) {
            return String.format(Locale.US, "%d days", days);
        } else if (hours > 0) {
            return String.format(Locale.US, "%d hours", hours);
        } else if (minutes > 0) {
            return String.format(Locale.US, "%d minutes", minutes);
        } else if (seconds > 0){
            return String.format(Locale.US, "%d seconds", seconds);
        } else {
            return String.format(Locale.US, "%d millis", millis);
        }
    }

}
