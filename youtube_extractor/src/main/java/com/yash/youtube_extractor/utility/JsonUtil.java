package com.yash.youtube_extractor.utility;

import com.yash.youtube_extractor.constants.ResponseFrom;

import java.util.HashMap;
import java.util.Map;

public class JsonUtil {

    private static final Map<Character, Character> endCharacterMap;

    static {
        endCharacterMap = new HashMap<>();
        endCharacterMap.put('{', '}');
        endCharacterMap.put('[', ']');
        endCharacterMap.put('(', ')');
    }

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

    public static String extractJsonFromHtmlV2(String initial, String html, ResponseFrom responseFrom) {
        int stIndex = html.indexOf(initial);
        StringBuilder builder = new StringBuilder();
        if (stIndex == -1) return builder.toString();
        char ch;
        char startChar = responseFrom == ResponseFrom.START ? initial.charAt(0) : initial.charAt(initial.length() - 1);
        Character endCharacter = endCharacterMap.get(startChar);
        char endChar = endCharacter == null ? startChar : endCharacter;
        int counter = 0;
        for (int st = stIndex + initial.length() - 1; st < html.length(); st++) {
            ch = html.charAt(st);
            builder.append(ch);
            if (ch == startChar) {
                counter++;
                continue;
            }
            if (ch == endChar) {
                counter--;
                if (counter == 0) break;
            }
        }
        return builder.toString();
    }


    public static String extractJsonFromHtmlV3(String initial, String html, ResponseFrom responseFrom) {
        int stIndex = html.indexOf(initial);
        StringBuilder builder = new StringBuilder();
        if (stIndex == -1) return builder.toString();
        char ch;
        char startChar = responseFrom == ResponseFrom.START ? initial.charAt(0) : initial.charAt(initial.length() - 1);
        Character endCharacter = endCharacterMap.get(startChar);
        char endChar = endCharacter == null ? startChar : endCharacter;
        int counter = 0;
        boolean dQuoteStarted = false;
        boolean sQuoteStarted = false;
        for (int st = stIndex + initial.length() - 1; st < html.length(); st++) {
            ch = html.charAt(st);
            builder.append(ch);
            if(ch == '"' && !sQuoteStarted) {
                dQuoteStarted = !dQuoteStarted;
            }

            if(ch == '\'' && !dQuoteStarted) {
                sQuoteStarted = !sQuoteStarted;
            }

            if (ch == startChar && !(dQuoteStarted || sQuoteStarted)) {
                counter++;
                continue;
            }
            if (ch == endChar && !(dQuoteStarted || sQuoteStarted)) {
                counter--;
                if (counter == 0) break;
            }
        }
        return builder.toString();
    }


    public static String extractJsonFromHtmlV2(String initial, String html, ResponseFrom responseFrom, int offset) {
        StringBuilder builder = new StringBuilder();
        if(initial.length()<offset)
            return builder.toString();
        int stIndex = html.indexOf(initial);
        if (stIndex == -1) return builder.toString();
        char ch;
        char startChar = responseFrom == ResponseFrom.START ? initial.charAt(offset) : initial.charAt(initial.length() - offset - 1);
        stIndex += offset;
        Character endCharacter = endCharacterMap.get(startChar);
        char endChar = endCharacter == null ? startChar : endCharacter;
        int counter = 0;
        for (int st = stIndex; st < html.length(); st++) {
            ch = html.charAt(st);
            builder.append(ch);
            if (ch == startChar) {
                counter++;
                continue;
            }
            if (ch == endChar) {
                counter--;
                if (counter == 0) break;
            }
        }
        return builder.toString();
    }
}
