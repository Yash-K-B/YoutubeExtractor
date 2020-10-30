package com.yash.ymplayer.helper;

import android.util.Log;

public class LogHelper {
    private static final String TAG = "YOUTUBE_EXTRACTOR";
    public static void d(String tag, String message){
        Log.d(TAG,tag + ": "+message);
    }
}
