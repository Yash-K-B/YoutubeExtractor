package com.yash.youtube_extractor.utility;

import android.os.FileUtils;
import android.util.Log;

import com.yash.youtube_extractor.pojo.common.LengthText;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import okhttp3.Headers;

public class CommonUtility {
    private static final String TAG = "CommonUtility";

    public static String getHtmlString(String url) {
        try {
            return HttpUtility.getInstance().get(url);
        } catch (IOException e) {
            Log.e(TAG, "getHtmlString: ", e);
            return "";
        }
    }


    public static JSONObject getData(String videoId) throws JSONException {
        try {
        JSONObject clientContext = RequestUtility.buildClientContext();
        clientContext.put("videoId", videoId);
        return new JSONObject(HttpUtility.getInstance().post(RequestUtility.YOUTUBE_DATA_API, clientContext.toString(), Headers.of("Content-Type","application/json", "X-Goog-Visitor-Id", clientContext.getString("X-Goog-Visitor-Id"))));
        } catch (IOException e) {
            Log.e(TAG, "Failed to get youtube data: ", e);
            return null;
        }
    }

    public static String getHtmlString(String url, String method, String requestBody) {
        StringBuilder result = new StringBuilder();
        try {
            URL webUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) webUrl.openConnection();
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/104.0.0.0 Safari/537.36");
            connection.setRequestMethod(method);
            // write request body
            if(StringUtils.isNotBlank(requestBody)) {
                connection.setDoOutput(true);
                connection.setRequestProperty("content-type", "application/json");
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
                writer.write(requestBody);
                writer.flush();
                writer.close();
            }

            // Read response
            int responseCode = connection.getResponseCode();
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

    public static String getHtmlUnescapedString(String url) {
        StringBuilder result = new StringBuilder();
        try {
            URL webUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) webUrl.openConnection();
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/104.0.0.0 Safari/537.36");
            //connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_6) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/13.0.3 Safari/605.1.15");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                result.append(StringEscapeUtils.unescapeJava(line.replace("\\x", "\\u00")));
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
