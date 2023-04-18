package com.yash.youtube_extractor.utility;

import android.content.Context;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class HttpUtility {
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
                .readTimeout(60, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .connectTimeout(40, TimeUnit.SECONDS)
                .build();
        this.cacheControl = cacheControl;
    }

    private HttpUtility() {
        this.client = new OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .connectTimeout(40, TimeUnit.SECONDS)
                .build();
    }


    public static void initialise(Cache cache, CacheControl cacheControl) {
        instance = new HttpUtility(cache, cacheControl);
    }


    public String get(String url) throws IOException {
        Request.Builder builder = new Request.Builder().url(url);
        if(cacheControl != null)
            builder.cacheControl(cacheControl);

        Request request = builder.build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public String post(String url, String payload) throws IOException {
        Request.Builder builder = new Request.Builder().url(url);
        if(cacheControl != null)
            builder.cacheControl(cacheControl);
        builder.post(RequestBody.create(payload, MediaType.parse("application/json")));

        Request request = builder.build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }



}
