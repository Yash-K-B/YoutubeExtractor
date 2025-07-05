package com.yash.youtubeextractor;

import android.app.Application;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.preference.PreferenceManager;

import com.yash.logging.LogHelper;
import com.yash.youtube_extractor.receivers.ConnectivityReceiver;
import com.yash.youtube_extractor.utility.HttpUtility;
import com.yash.youtube_extractor.utility.RequestUtility;

import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;

public class YoutubeExtractor extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        LogHelper.deploy(this,"YoutubeExtractor");

//        HttpUtility.initialise(new Cache(getCacheDir(), 41_943_040), new CacheControl.Builder().maxAge(4, TimeUnit.HOURS).maxStale(4, TimeUnit.HOURS).build());
        HttpUtility.initialise(new Cache(getCacheDir(), 41_943_040), null);
        RequestUtility.updateSettings(PreferenceManager.getDefaultSharedPreferences(this));
        registerReceiver(new ConnectivityReceiver(), new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
    }
}
