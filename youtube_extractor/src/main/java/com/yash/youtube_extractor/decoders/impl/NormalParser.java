package com.yash.youtube_extractor.decoders.impl;

import android.os.SystemClock;
import android.util.Log;

import com.yash.youtube_extractor.constants.ResponseFrom;
import com.yash.youtube_extractor.decoders.YParser;
import com.yash.youtube_extractor.utility.ConverterUtil;
import com.yash.youtube_extractor.utility.JsonUtil;
import com.yash.youtube_extractor.utility.RegExUtility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NormalParser implements YParser {
    private static final String TAG = "NormalParser";
    private static final Pattern throttleFunc = Pattern.compile(RegExUtility.getNSigRegex());
    @Override
    public YParseResponse parse(String playerJs) {

        StringBuilder functions = new StringBuilder();
        String auxFuncName = null;
        String decodeFunctionName = null;
        Pattern decoderFunc = Pattern.compile("([A-za-z0-9_$]{2,3})=function\\([A-Za-z0-9]+\\)\\{[A-Za-z0-9]+=[A-Za-z0-9]+.split\\(\"\"\\);([A-za-z0-9_$]+)\\..*\\}");//"=([A-za-z0-9_]+)\\(decodeURIComponent\\([.\\w]+\\)\\)");
        Matcher m = decoderFunc.matcher(playerJs);
        if (m.find()) {
            functions.append("var ").append(m.group(0)).append(";");
            decodeFunctionName = m.group(1);
            auxFuncName = m.group(2);
        }
        Pattern auxFunc = Pattern.compile("var " + (auxFuncName != null ? auxFuncName.replace("$", "\\$") : "") + "\\s*=\\s*\\{(.*\\n*){0,3}\\}\\};");
        Matcher auxMatcher = auxFunc.matcher(playerJs);
        if (auxMatcher.find()) {
            functions.append(auxMatcher.group(0));
        }


        // Throttle Function
        String throttleDecoderFunctionName = null;
        Matcher throttleMatcher = throttleFunc.matcher(playerJs);
        if (throttleMatcher.find()) {
            throttleDecoderFunctionName = throttleMatcher.group(1);

//            intermediate = end;
//            end = SystemClock.currentThreadTimeMillis();
//            Log.d("YOUTUBE_EXTRACTOR", "Throttle function name found in : " + ConverterUtil.formatDuration(end - intermediate));


            String initKey = String.format("%s=function(%s){", throttleDecoderFunctionName, throttleMatcher.group(2));
            String throttleDecoderFunction = JsonUtil.extractJsFunctionFromHtmlJs(initKey, playerJs, ResponseFrom.END);
            String func = "var " + throttleDecoderFunctionName + "=function(" + throttleMatcher.group(2) + ")" + throttleDecoderFunction + ";";
            Log.d(TAG, "f = " + func);

            Pattern externalDependency = Pattern.compile("if\\(typeof ([A-Za-z0-9$]+)===\"undefined\"");
            Matcher externalDependencyMatcher = externalDependency.matcher(throttleDecoderFunction);
            if (externalDependencyMatcher.find()) {
                String externalDependentVariable = externalDependencyMatcher.group(1);
                Matcher extraCode = Pattern.compile("var " + externalDependentVariable + "=[^;]+").matcher(playerJs);
                if (extraCode.find()) {
                    Log.d(TAG, "Extra code: " + extraCode.group(0));
                    functions.append(extraCode.group(0)+";");
                }
            }
            functions.append(func);
        }



        return YParseResponse.builder()
                .script(functions.toString())
                .decoderFunctionName(decodeFunctionName)
                .throttleFunctionName(throttleDecoderFunctionName)
                .build();
    }
}
