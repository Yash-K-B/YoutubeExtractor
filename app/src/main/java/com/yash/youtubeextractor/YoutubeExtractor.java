package com.yash.youtubeextractor;

import android.app.Application;

import com.yash.logging.LogHelper;

public class YoutubeExtractor extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        LogHelper.deploy(this,"YoutubeExtractor");
    }
}
