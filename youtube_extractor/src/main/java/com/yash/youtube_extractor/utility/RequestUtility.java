package com.yash.youtube_extractor.utility;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import org.apache.commons.lang.StringUtils;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.prefs.Preferences;

public class RequestUtility {

    // Keys
    private static final String VISITOR_DATA_KEY = "VISITOR_DATA_KEY";
    private static final String LANGUAGE_KEY = "LANGUAGE_KEY";
    private static final String LOCATION_KEY = "LOCATION_KEY";
    private static final String CLIENT_VERSION_KEY = "CLIENT_VERSION_KEY";
    private static final String CLIENT_API_KEY = "CLIENT_API_KEY";

    // Urls
    public static final String YOUTUBE_DATA_API = "https://www.youtube.com/youtubei/v1/player?prettyPrint=false";
    private static final String BROWSE_URL_PLACEHOLDER = "https://youtubei.googleapis.com/youtubei/v1/browse?key=%s&prettyPrint=false";
    private static final String NEXT_URL_PLACEHOLDER = "https://youtubei.googleapis.com/youtubei/v1/next?key=%s&prettyPrint=false";
    private static final String SEARCH_URL_PLACEHOLDER = "https://www.youtube.com/youtubei/v1/search?key=%s&prettyPrint=false";

    private static final Map<String, String> preferences = new HashMap<>();

    // Default values
    public static final String DEFAULT_API_KEY = "AIzaSyAO_FJ2SlqU8Q4STEHLGCilw_Y9_11qcW8";
    public static final String DEFAULT_LANGUAGE = "en";
    public static final String DEFAULT_VERSION = "2.20230309.08.00";
    public static final String DEFAULT_LOCATION = "IN";
    public static final String DEFAULT_VISITOR_DATA = "CgtaQ05lWnA2d0FmYyiq882gBg%3D%3D";

    public static JSONObject buildContext() {
        Map<String, String> client = new HashMap<>();
        client.put("connectionType", "CONN_CELLULAR_4G");
        client.put("hl", getLanguage());
        client.put("clientName", "WEB");
        client.put("screenHeightPoints", "1002");
        client.put("visitorData", getVisitorData());
        client.put("screenWidthPoints", "1246");
        client.put("platform", "DESKTOP");
        client.put("deviceMake", "Apple");
        client.put("userInterfaceTheme", "USER_INTERFACE_THEME_DARK");
        client.put("gl", getLocation());
        client.put("utcOffsetMinutes", "330");
        client.put("screenPixelDensity", "1");
        client.put("osName", "Macintosh");
        client.put("clientVersion", getClientVersion());
        client.put("osVersion", "10_15_7");
        client.put("browserVersion", "87.0.4280.88");
        client.put("browserName", "Chrome");
        client.put("userAgent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 11_0_1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.88 Safari/537.36,gzip(gfe)");
        client.put("screenDensityFloat", "1");
        Map<String, Map<String, String>> context = new HashMap<>();
        context.put("request", new HashMap<>());
        context.put("client", client);
       return new JSONObject(context);
    }


    public static JSONObject buildClientContext() {
        Map<String, Object> client = new HashMap<>();
        client.put("clientName", "IOS");
        client.put("clientVersion", "19.29.1");
        client.put("deviceMake", "Apple");
        client.put("deviceModel", "iPhone16,2");
        client.put("userAgent", "com.google.ios.youtube/19.29.1 (iPhone16,2; U; CPU iOS 17_5_1 like Mac OS X;)");
        client.put("osName", "iPhone");
        client.put("osVersion", "17.5.1.21F90");
        client.put("hl", getLanguage());
        client.put("timeZone", "UTC");
        client.put("utcOffsetMinutes", 0);


        Map<String, Object> context = new HashMap<>();
        context.put("context", Map.of("client", client));
        context.put("playbackContext", Map.of("contentPlaybackContext", Map.of("html5Preference", "HTML5_PREF_WANTS")));
        context.put("contentCheckOk", true);
        context.put("racyCheckOk", true);
        context.put("X-Goog-Visitor-Id", getVisitorData());

        return new JSONObject(context);
    }



    public static JSONObject buildContinuationRequest(String continuationToken) {
        JSONObject request = new JSONObject();
        try {
            request.put("context", buildContext());
            request.put("continuation", continuationToken);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return request;
    }


    private static String getOrDefault(String key, String defaultValue) {
        String v;
        return (((v = preferences.get(key)) != null) || preferences.containsKey(key)) ? v : defaultValue;
    }

    public static String getClientApiKey() {
        return getOrDefault(CLIENT_API_KEY, DEFAULT_API_KEY);
    }

    public static String getLanguage() {
        return getOrDefault(LANGUAGE_KEY, DEFAULT_LANGUAGE);
    }

    public static String getClientVersion() {
        return getOrDefault(CLIENT_VERSION_KEY, DEFAULT_VERSION);
    }

    public static String getLocation() {
        return getOrDefault(LOCATION_KEY, RequestUtility.DEFAULT_LOCATION);
    }

    public static String getVisitorData() {
        return getOrDefault(VISITOR_DATA_KEY, DEFAULT_VISITOR_DATA);
    }

    public static String getBrowseUrl() {
        return String.format(BROWSE_URL_PLACEHOLDER, getClientApiKey());
    }

    public static String getNextUrl() {
        return String.format(NEXT_URL_PLACEHOLDER, getClientApiKey());
    }

    public static String getSearchUrl() {
        return String.format(SEARCH_URL_PLACEHOLDER, getClientApiKey());
    }

    public static void updateSettings(SharedPreferences sharedPreferences) {
        if(sharedPreferences == null)
            return;
        preferences.put(VISITOR_DATA_KEY, sharedPreferences.getString(VISITOR_DATA_KEY, DEFAULT_VISITOR_DATA));
        preferences.put(LOCATION_KEY, sharedPreferences.getString(LOCATION_KEY, DEFAULT_LOCATION));
        preferences.put(LANGUAGE_KEY, sharedPreferences.getString(LANGUAGE_KEY, DEFAULT_LANGUAGE));
        preferences.put(CLIENT_API_KEY, sharedPreferences.getString(CLIENT_API_KEY, DEFAULT_API_KEY));
        preferences.put(CLIENT_VERSION_KEY, sharedPreferences.getString(CLIENT_VERSION_KEY, DEFAULT_VERSION));
    }
}
