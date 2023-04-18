package com.yash.youtube_extractor.utility;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class RequestUtility {

    public static JSONObject buildContext() {
        Map<String, String> client = new HashMap<>();
        client.put("connectionType", "CONN_CELLULAR_4G");
        client.put("hl", "en");
        client.put("clientName", "WEB");
        client.put("screenHeightPoints", "1002");
        client.put("visitorData", "CgtaQ05lWnA2d0FmYyiq882gBg%3D%3D");
        client.put("screenWidthPoints", "1246");
        client.put("platform", "DESKTOP");
        client.put("deviceMake", "Apple");
        client.put("userInterfaceTheme", "USER_INTERFACE_THEME_DARK");
        client.put("gl", "IN");
        client.put("utcOffsetMinutes", "330");
        client.put("screenPixelDensity", "1");
        client.put("osName", "Macintosh");
        client.put("clientVersion", "2.20230309.08.00");
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
}
