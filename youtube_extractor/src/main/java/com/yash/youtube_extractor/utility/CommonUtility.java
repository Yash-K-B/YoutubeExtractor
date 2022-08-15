package com.yash.youtube_extractor.utility;

import com.yash.youtube_extractor.pojo.common.LengthText;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CommonUtility {
    public static String getHtmlString(String url) {
        StringBuilder result = new StringBuilder();
        try {
            URL webUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) webUrl.openConnection();
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/104.0.0.0 Safari/537.36");
            //connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_6) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/13.0.3 Safari/605.1.15");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            int numChar;
            char[] buffer = new char[131072];
            while ((numChar = bufferedReader.read(buffer)) != -1) {
                result.append(buffer, 0, numChar);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    public static long stringToMillis(String time) {
        if (time == null || time.isEmpty())
            return 0L;
        String[] splits = time.split(":");
        long result = 0L;
        for (String split : splits) {
            result *= 60;
            result += Integer.parseInt(split);
        }
        return result;
    }

    public static long fromLengthText(LengthText lengthText) {
        return stringToMillis(lengthText == null ? null : lengthText.getSimpleText());
    }
}
