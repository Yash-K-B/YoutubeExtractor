package com.yash.youtubeextractor;

import android.app.Application;
import android.preference.PreferenceManager;

import com.yash.logging.LogHelper;
import com.yash.youtube_extractor.utility.HttpUtility;
import com.yash.youtube_extractor.utility.RequestUtility;

import okhttp3.Cache;

public class YoutubeExtractor extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        LogHelper.deploy(this,"YoutubeExtractor");

        HttpUtility.initialise(new Cache(getCacheDir(), 41_943_040), null);
        RequestUtility.updateSettings(PreferenceManager.getDefaultSharedPreferences(this));
    }
}
