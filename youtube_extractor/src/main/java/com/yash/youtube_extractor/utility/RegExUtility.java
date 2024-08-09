package com.yash.youtube_extractor.utility;

public class RegExUtility {

    public static String getNSigRegex() {
        return "\\|\\|(?<NFUNC>[A-Za-z0-9]+)\\(\"\"\\)";
    }

}
