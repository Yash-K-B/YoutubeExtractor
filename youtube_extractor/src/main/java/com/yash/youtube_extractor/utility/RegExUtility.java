package com.yash.youtube_extractor.utility;

public class RegExUtility {

    public static String getNSigRegex() {
        return "([A-Za-z0-9$]+)=function\\(([A-Za-z0-9]+)\\)\\{var [A-Za-z0-9]+=[A-Za-z0-9]+.split\\([A-Za-z0-9]+.slice\\(0,0\\)\\)";
    }

}
