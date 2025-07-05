package com.yash.youtube_extractor.decoders.impl;

import android.util.Log;

import com.yash.youtube_extractor.constants.ResponseFrom;
import com.yash.youtube_extractor.decoders.YParser;
import com.yash.youtube_extractor.utility.JsonUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FunctionNameHiddenParser implements YParser {
    private static final String TAG = "FunctionNameHiddenParse";

    private static final Pattern decoderFunctionNamePattern = Pattern.compile("([A-za-z0-9_]+)\\(decodeURIComponent\\([A-Za-z0-9_$]+\\.s\\)");
    private static final Pattern throttleFunctionNamePattern = Pattern.compile("([A-za-z0-9_]+)=function\\(([A-za-z0-9_]+)\\)\\{var [A-za-z0-9_]+=[A-za-z0-9_]+\\[.+?\\]\\(.+?\\),[A-za-z0-9_]+=\\[");

    @Override
    public YParseResponse parse(String playerJs) {
        StringBuilder functions = new StringBuilder();
        Matcher decoderFunctionMatcher = decoderFunctionNamePattern.matcher(playerJs);
        String decodeFunctionName = null;
        if (decoderFunctionMatcher.find()) {
            // Decoder function
            decodeFunctionName = decoderFunctionMatcher.group(1);
            String decoderFunction = JsonUtil.extractJsFunctionImpl(decodeFunctionName + "=", '{', playerJs, ResponseFrom.START);
            functions.append("var ").append(decodeFunctionName).append(decoderFunction).append(";");

            Pattern auxAndHelper = Pattern.compile(";([A-Za-z0-9_$]+)\\[([A-Za-z0-9_$]+)\\[.*?\\]\\]\\(.*?\\);");
            Matcher auxHelperMatcher = auxAndHelper.matcher(decoderFunction);
            String auxFuncName = null;
            if (auxHelperMatcher.find()) {
                auxFuncName = auxHelperMatcher.group(1);
                String helper = auxHelperMatcher.group(2);
                String helperFunction = JsonUtil.extractWithRegex("var " + helper + "='.*?'\\.split\\(.*?\\)", playerJs);
                functions.append(helperFunction).append(";");
            }

            // Axillary function
            Pattern auxFunc = Pattern.compile("var " + (auxFuncName != null ? auxFuncName.replace("$", "\\$") : "") + "\\s*=\\s*\\{(.*\\n*){0,3}\\}\\};");
            Matcher auxMatcher = auxFunc.matcher(playerJs);
            if (auxMatcher.find()) {
                functions.append(auxMatcher.group(0));
            }

        }

        // Throttle function
        Matcher matcher = throttleFunctionNamePattern.matcher(playerJs);
        String throttleFunctionName = null;
        if (matcher.find()) {
            throttleFunctionName = matcher.group(1);
            String throttleFunction = JsonUtil.extractJsFunctionImpl(throttleFunctionName + "=", '{', playerJs, ResponseFrom.START);
            functions.append("var ").append(throttleFunctionName).append(throttleFunction).append(";");

            Pattern externalDependency = Pattern.compile("if\\(typeof ([A-Za-z0-9$]+)===.+?\\)");
            Matcher externalDependencyMatcher = externalDependency.matcher(throttleFunction);
            if (externalDependencyMatcher.find()) {
                String externalDependentVariable = externalDependencyMatcher.group(1);
                Matcher extraCode = Pattern.compile("var " + externalDependentVariable + "=[^;]+").matcher(playerJs);
                if (extraCode.find()) {
                    Log.d(TAG, "Extra code: " + extraCode.group(0));
                    functions.append(extraCode.group(0)).append(";");
                }
            }
        }


        return YParseResponse.builder()
                .decoderFunctionName(decodeFunctionName)
                .throttleFunctionName(throttleFunctionName)
                .script(functions.toString())
                .build();
    }
}
