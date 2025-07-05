package com.yash.youtube_extractor;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;


import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.yash.youtube_extractor.constants.ResponseFrom;
import com.yash.youtube_extractor.decoders.YParser;
import com.yash.youtube_extractor.decoders.YParser.YParseResponse;
import com.yash.youtube_extractor.decoders.impl.FunctionNameHiddenParser;
import com.yash.youtube_extractor.decoders.impl.NormalParser;
import com.yash.youtube_extractor.exceptions.ExtractionException;
import com.yash.youtube_extractor.models.ChannelThumbnail;
import com.yash.youtube_extractor.models.Decoder;
import com.yash.youtube_extractor.models.StreamingData;
import com.yash.youtube_extractor.models.VideoData;
import com.yash.youtube_extractor.models.VideoDetails;
import com.yash.youtube_extractor.utility.CommonUtility;
import com.yash.youtube_extractor.utility.ConverterUtil;
import com.yash.youtube_extractor.utility.HttpUtility;
import com.yash.youtube_extractor.utility.JsonUtil;
import com.yash.youtube_extractor.utility.RegExUtility;
import com.yash.youtube_extractor.utility.RequestUtility;

import org.apache.commons.lang.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.ScriptableObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Extractor {

    private final ExecutorService executorService = Executors.newSingleThreadExecutor();
    private static final String TAG = "Extractor";
    public static final String BASE_URL = "https://www.youtube.com/watch?v=";
    Context context;
    ScriptableObject scope;
    Function decoderFunction;
    Function throttleFunction;
    Handler handler;

    public Extractor() {
        handler = new Handler(Looper.getMainLooper());
    }

    public VideoDetails extract(String videoId) throws ExtractionException {
        // TODO: 09/08/24 add in url "?bpctr=9999999999&has_verified=1";
        String url = BASE_URL + videoId;
        try {
            long start, end, intermediate;
            Log.d("YOUTUBE_EXTRACTOR", "Starting extraction of video id - " + videoId);
            intermediate = start = SystemClock.currentThreadTimeMillis();
            String html = CommonUtility.getHtmlString(url);


            end = SystemClock.currentThreadTimeMillis();
            Log.d("YOUTUBE_EXTRACTOR", "HTML downloaded in : " + ConverterUtil.formatDuration(end - intermediate));
            if(StringUtils.isBlank(html))
                throw new ExtractionException("Unable to retrieve metadata");

            String decodeFunctionName = "";
            String throttleDecoderFunctionName = "";
            context = Context.enter();
            scope = context.initStandardObjects();
            int stIndex = html.indexOf("\"player_response\":\"{");
            String result = "";
            if (stIndex != -1) {
                int enIndex = html.indexOf("}\"", stIndex);
                result = html.substring(stIndex + 19, enIndex) + "}";
                result = result.replace("\\\\u0026", "&");
                result = result.replace("\\\"", "\"");
                result = result.replace("\\\\", "\\");
            } else {
                result = extractJsonFromHtml(html);
            }

            Moshi moshi = new Moshi.Builder().build();

            /* EXTRACTING Channel Thumbnails */
            String channelThumbnailJson = JsonUtil.extractJsonFromHtml("\"channelThumbnail\":{", html);
            ChannelThumbnail channelThumbnail = moshi.adapter(ChannelThumbnail.class).fromJson(channelThumbnailJson);


            JSONObject object = new JSONObject(result);
            StreamingData streamingData = moshi.adapter(StreamingData.class).fromJson(object.getString("streamingData"));


            String jsUrlPattern = "\"PLAYER_JS_URL\":\"([A-za-z0-9/.]+)\"";
            Pattern pattern = Pattern.compile(jsUrlPattern);
            Matcher matcher = pattern.matcher(html);
            String playerJs;
            if (matcher.find()) {
                playerJs = HttpUtility.getInstance().get("https://www.youtube.com" + Objects.requireNonNull(matcher.group(1)).replace("\\/", "/"));
            } else {
                throw new ExtractionException("Player JS Not available");
            }
            intermediate = end;
            end = SystemClock.currentThreadTimeMillis();
            Log.d("YOUTUBE_EXTRACTOR", "Player Script downloaded in : " + ConverterUtil.formatDuration(end - intermediate));

            StringBuilder functions = new StringBuilder();

            int index = result.indexOf("\"signatureCipher\"");

            /*
             * Function name regex = =([A-za-z0-9_]+)\(decodeURIComponent\([.\w]+\)\)
             * Function regex = ([A-za-z0-9_$]{2,3})=function\(a\)\{a=a.split\(""\);([A-za-z0-9_$]+)\..*\\}
             * Axillary function = var " + auxFuncName + "\\s*=\\s*\\{(.*\\n*){0,3}\\}\\};
             */

            YParseResponse response = YParseResponse.empty();
            if (index != -1) {
                YParser parser;
                if (playerJs.contains(";split;")) {
                    parser = new FunctionNameHiddenParser();
                } else {
                    parser = new NormalParser();
                }
                response = parser.parse(playerJs);
            }
            intermediate = end;
            end = SystemClock.currentThreadTimeMillis();
            Log.d("YOUTUBE_EXTRACTOR", "Cipher decoder and throttle function found in : " + ConverterUtil.formatDuration(end - intermediate));


//            intermediate = end;
//            end = SystemClock.currentThreadTimeMillis();
//            Log.d("YOUTUBE_EXTRACTOR", "Throttle function found in : " + ConverterUtil.formatDuration(end - intermediate));


            context.setOptimizationLevel(-1);
            context.evaluateString(scope, response.getScript(), "script", 1, null);


            if (response.hasDecoderFunction())
                decoderFunction = (Function) scope.get(response.getDecoderFunctionName(), scope);
            if (response.hasThrottleFunction())
                throttleFunction = (Function) scope.get(response.getThrottleFunctionName(), scope);
            streamingData.initObject(new Decoder() {
                @Override
                public String decodeSignature(String signature) {
                    return (String) decoderFunction.call(context, scope, scope, new Object[]{signature});
                }

                @Override
                public String decodeThrottle(String throttle) {
                    if(throttleFunction == null || throttle == null)
                        return throttle;
                    return (String) throttleFunction.call(context, scope, scope, new Object[]{throttle});
                }
            });

            intermediate = end;
            end = SystemClock.currentThreadTimeMillis();
            Log.d("YOUTUBE_EXTRACTOR", "Links build in : " + ConverterUtil.formatDuration(end - intermediate));


            VideoData videoData = moshi.adapter(VideoData.class).fromJson(object.getString("videoDetails"));
            videoData.setChannelThumbnail(channelThumbnail);

            end = SystemClock.currentThreadTimeMillis();
            Log.d("YOUTUBE_EXTRACTOR", "extract : " + ConverterUtil.formatDuration(end - start));
            return new VideoDetails(streamingData, videoData);

        } catch (Exception e) {
            Log.e(TAG, "Error in extraction :", e);
            throw new ExtractionException(e.toString());
        }
    }

    public void extract(String videoId, Callback callback) {
        executorService.execute(() -> {
            try {
                VideoDetails videoDetails = extractV2(videoId);
                handler.post(() -> callback.onSuccess(videoDetails));

            } catch (ExtractionException e) {
                handler.post(() -> callback.onError(e));
            }
        });

    }


    public String extractJsonFromHtml(String html) {
        int stIndex = html.indexOf("\"responseContext\":{");
        StringBuilder builder = new StringBuilder();
        char ch;
        int counter = 0;
        for (int st = stIndex - 1; st < html.length(); st++) {
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


    public VideoDetails extractV2(String videoId) throws ExtractionException {
        long start, end;
        Log.d("YOUTUBE_EXTRACTOR", "Starting extraction of video id - " + videoId);
        start = SystemClock.currentThreadTimeMillis();
        try {
            String html = CommonUtility.getHtmlString(BASE_URL + videoId);
            RequestUtility.initializeMetadata(html);
            JSONObject data = CommonUtility.getData(videoId);
            if(data == null) {
                throw new ExtractionException("Failed to extract data");
            }

            Moshi moshi = new Moshi.Builder().build();
            StreamingData streamingData = moshi.adapter(StreamingData.class).fromJson(data.getString("streamingData"));
            streamingData.initObject(null);

            VideoData videoData = moshi.adapter(VideoData.class).fromJson(data.getString("videoDetails"));
//            videoData.setChannelThumbnail(channelThumbnail);

            end = SystemClock.currentThreadTimeMillis();
            Log.d("YOUTUBE_EXTRACTOR", "extract : " + ConverterUtil.formatDuration(end - start));
            return new VideoDetails(streamingData, videoData);

        } catch (JSONException | IOException e) {
            Log.e(TAG, "extractV2: Failed to extract details of video id : " + videoId, e);
            throw new ExtractionException(e.getMessage(), e);
        }

    }




    public interface Callback {
        void onSuccess(VideoDetails videoDetails);

        void onError(ExtractionException e);
    }
}
