package com.yash.youtube_extractor.utility;

import android.util.Log;

import com.yash.youtube_extractor.constants.ResponseFrom;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JsonUtil {
    private static final String TAG = "JsonUtil";

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

    public static String extractJsFunctionFromHtmlJs(String initial, String html, ResponseFrom responseFrom) {
        return extractJsFunctionImpl(initial, null, html, responseFrom);
    }

    public static String extractJsFunctionImpl(String initial, Character anchorChar, String html, ResponseFrom responseFrom) {
        int stIndex = html.indexOf(initial);
        StringBuilder builder = new StringBuilder();
//        StringBuilder regExBuilder = new StringBuilder();
        if (stIndex == -1) return builder.toString();
        char ch, preCh, preCh2;
        char startChar = anchorChar == null ? (responseFrom == ResponseFrom.START ? initial.charAt(0) : initial.charAt(initial.length() - 1)) : anchorChar;
        Character endCharacter = endCharacterMap.get(startChar);
        char endChar = endCharacter == null ? startChar : endCharacter;
        int counter = 0;
        boolean dQuoteStarted = false;
        boolean sQuoteStarted = false;
        boolean regExStarted = false;
        boolean regexCharSetStarted = false;
        for (int st = stIndex + initial.length() - 1; st < html.length(); st++) {
            preCh2 = html.charAt(st - 2);
            preCh = html.charAt(st - 1);
            ch = html.charAt(st);
            builder.append(ch);

            if(regExStarted && ch=='[' && !isEscaped(preCh, preCh2)) {
                regexCharSetStarted = true;
            }

            if(regExStarted && regexCharSetStarted && ch==']' && !isEscaped(preCh, preCh2)) {
                regexCharSetStarted = false;
            }

            if(!(dQuoteStarted || sQuoteStarted) && !regExStarted && (preCh == ',' || preCh == '(') && ch == '/') {
                Log.i(TAG, "Regex started");
                regExStarted = true;
            } else if(!(dQuoteStarted || sQuoteStarted) && !regexCharSetStarted && regExStarted && ((ch == '/' && !isEscaped(preCh, preCh2)) || (ch == 'g' && preCh != '/'))) {
                Log.i(TAG, "Regex ended");
                regExStarted = false;
            }

//            if(regExStarted) {
//                regExBuilder.append(ch);
//            } else if (regExBuilder.length() > 0) {
//                Log.i(TAG, "RegEx found : " + regExBuilder);
//                regExBuilder = new StringBuilder();
//            }

            if(ch == '"' && !isEscaped(preCh, preCh2) && !(sQuoteStarted || regExStarted)) {
                dQuoteStarted = !dQuoteStarted;
            }

            if(ch == '\'' && !isEscaped(preCh, preCh2) && !(dQuoteStarted || regExStarted)) {
                sQuoteStarted = !sQuoteStarted;
            }

            if (ch == startChar && !isEscaped(preCh, preCh2) && !(dQuoteStarted || sQuoteStarted || regExStarted)) {
                counter++;
                continue;
            }
            if (ch == endChar && !isEscaped(preCh, preCh2) && !(dQuoteStarted || sQuoteStarted || regExStarted)) {
                counter--;
                if (counter == 0) break;
            }
        }
        return builder.toString();
    }

    private static boolean isEscaped(char pch1, char pch2) {
        if(pch1 != '\\')
            return false;

        return pch2 != '\\';
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


    public static String extractWithRegex(String regex, String text) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        if(matcher.find()) {
            return matcher.group(0);
        } else {
            return "";
        }
    }
}
