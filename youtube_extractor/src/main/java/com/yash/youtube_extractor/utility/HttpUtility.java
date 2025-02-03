package com.yash.youtube_extractor.utility;

import android.content.Context;
import android.util.Log;

import com.yash.youtube_extractor.interfaces.NetworkListener;
import com.yash.youtube_extractor.receivers.ConnectivityReceiver;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class HttpUtility implements ConnectivityReceiver.ConnectivityReceiverListener {
    private static final String TAG = "HttpUtility";

    private static final int READ_TIMEOUT = 0;
    private static final int WRITE_TIMEOUT = 0;
    private static final int CONNECTION_TIMEOUT = 0;
    private static HttpUtility instance;
    public static HttpUtility getInstance() {
        if(instance == null)
            throw new RuntimeException("HttpUtility not initialised");
        return instance;
    }

    private final OkHttpClient client;
    private CacheControl cacheControl;
    private boolean isNetworkAvailable = true;

    private HttpUtility(Cache cache, CacheControl cacheControl) {
        this.client = new OkHttpClient.Builder()
                .cache(cache)
                .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
                .connectTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
                .addNetworkInterceptor(networkCacheInterceptor)
                .addInterceptor(cacheInterceptor)
                .build();
        this.cacheControl = cacheControl;
    }

    private HttpUtility() {
        this.client = new OkHttpClient.Builder()
                .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
                .connectTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
                .addNetworkInterceptor(networkCacheInterceptor)
                .addInterceptor(cacheInterceptor)
                .build();
    }


    public static void initialise(Cache cache, CacheControl cacheControl) {
        instance = new HttpUtility(cache, cacheControl);
    }


    Interceptor networkCacheInterceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Response originalResponse = chain.proceed(chain.request());
            String cacheControlStr = originalResponse.header("Cache-Control");
            if (cacheControl != null && (cacheControlStr == null || cacheControlStr.contains("no-store") || cacheControlStr.contains("no-cache") ||
                    cacheControlStr.contains("must-revalidate") || cacheControlStr.contains("max-age=0"))) {
                return originalResponse.newBuilder()
                        .removeHeader("Pragma")
                        .header("Cache-Control", "public, " + cacheControl.toString() )
                        .build();
            } else {
                return originalResponse;
            }
        }
    };

    private final Interceptor cacheInterceptor = chain -> {
        Request request = chain.request();
        if(!isNetworkAvailable) {
            request = request.newBuilder()
                    .removeHeader("Pragma")
                    .header("Cache-Control", "public, only-if-cached")
                    .build();
        }
        return chain.proceed(request);
    };

    public Headers getHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/132.0.0.0 Safari/537.36");
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

    public String getWith1MonthCache(String url) throws IOException {
        Request.Builder builder = new Request.Builder()
                .url(url)
                .headers(getHeaders());
        builder.cacheControl(new CacheControl.Builder().maxAge(30, TimeUnit.DAYS).maxStale(30, TimeUnit.DAYS).build());

        Request request = builder.build();
        try(Response response = client.newCall(request).execute()) {
            Log.i(TAG, "getWith1MonthCache: " + response.cacheResponse());
            Log.i(TAG, "getWith1MonthCache: " + response.networkResponse());
            return response.body().string();
        }
    }

    public String post(String url, String payload) throws IOException {
        return post(url, payload, getHeaders());
    }

    public String post(String url, String payload, Headers headers) throws IOException {
        Request.Builder builder = new Request.Builder()
                .url(url)
                .headers(headers);
        if(cacheControl != null)
            builder.cacheControl(cacheControl);
        builder.post(RequestBody.create(payload, MediaType.parse("application/json")));

        Request request = builder.build();
        try(Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    @Override
    public void onNetworkConnectionChanged(boolean isConnected) {
        isNetworkAvailable = isConnected;
    }
}
