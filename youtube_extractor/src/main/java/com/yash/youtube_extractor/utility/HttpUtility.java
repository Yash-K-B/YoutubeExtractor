package com.yash.youtube_extractor.utility;

import android.content.Context;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class HttpUtility {

    private static final int READ_TIMEOUT = 0;
    private static final int WRITE_TIMEOUT = 0;
    private static final int CONNECTION_TIMEOUT = 0;
    private static HttpUtility instance;
    public static HttpUtility getInstance() {
        if(instance == null)
            instance = new HttpUtility();
        return instance;
    }

    private final OkHttpClient client;
    private CacheControl cacheControl;

    private HttpUtility(Cache cache, CacheControl cacheControl) {
        this.client = new OkHttpClient.Builder()
                .cache(cache)
                .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
                .connectTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
                .build();
        this.cacheControl = cacheControl;
    }

    private HttpUtility() {
        this.client = new OkHttpClient.Builder()
                .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
                .connectTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
                .build();
    }


    public static void initialise(Cache cache, CacheControl cacheControl) {
        instance = new HttpUtility(cache, cacheControl);
    }

    public Headers getHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/112.0.0.0 Safari/537.36");
        return Headers.of(headers);
    }


    public String get(String url) throws IOException {
        Request.Builder builder = new Request.Builder()
                .url(url)
                .headers(getHeaders());
        if(cacheControl != null)
            builder.cacheControl(cacheControl);

        Request request = builder.build();
        try(Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    public String post(String url, String payload) throws IOException {
        Request.Builder builder = new Request.Builder()
                .url(url)
                .headers(getHeaders());
        if(cacheControl != null)
            builder.cacheControl(cacheControl);
        builder.post(RequestBody.create(payload, MediaType.parse("application/json")));

        Request request = builder.build();
        try(Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }



}
