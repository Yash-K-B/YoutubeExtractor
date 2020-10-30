package com.yash.youtube_extractor.helper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternHelper {
    private static final String TAG = "PatternHelper";

    public static Matcher getMatcher(String regex,String input){
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(input);
    }
}
