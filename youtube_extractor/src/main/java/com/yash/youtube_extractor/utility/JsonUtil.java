package com.yash.youtube_extractor.utility;

public class JsonUtil {
    public static String extractJsonFromHtml(String initial, String html) {
        int stIndex = html.indexOf(initial);
        StringBuilder builder = new StringBuilder();
        if (stIndex == -1) return builder.toString();
        char ch;
        int counter = 0;
        for (int st = stIndex + initial.length() - 1; st < html.length(); st++) {
            ch = html.charAt(st);
            builder.append(ch);
            if (ch == '{') {
                counter++;
                continue;
            }
            if (ch == '}') {
                counter--;
                if (counter == 0) break;
            }
        }
        return builder.toString();
    }
}
