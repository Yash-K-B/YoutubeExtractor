package com.yash.youtube_extractor;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;


import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.yash.youtube_extractor.exceptions.ExtractionException;
import com.yash.youtube_extractor.models.ChannelThumbnail;
import com.yash.youtube_extractor.models.StreamingData;
import com.yash.youtube_extractor.models.VideoData;
import com.yash.youtube_extractor.models.VideoDetails;
import com.yash.youtube_extractor.utility.CommonUtility;
import com.yash.youtube_extractor.utility.JsonUtil;

import org.json.JSONObject;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.ScriptableObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Extractor {
    private static final String TAG = "Extractor";
    public static final String BASE_URL = "https://www.youtube.com/watch?v=";
    Context context;
    ScriptableObject scope;
    Function decoderFunction;
    Handler handler;

    public Extractor() {
        handler = new Handler(Looper.getMainLooper());
    }

    public VideoDetails extract(String videoId) throws ExtractionException {
        String url = BASE_URL + videoId;
        try {
            long start, end;
            start = SystemClock.currentThreadTimeMillis();
            String html = CommonUtility.getHtmlString(url);
            String decodeFunctionName = "";
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

            int index = result.indexOf("\"signatureCipher\"");

            /*
             * Function name regex = =([A-za-z0-9_]+)\(decodeURIComponent\([.\w]+\)\)
             * Function regex = ([A-za-z0-9_$]{2,3})=function\(a\)\{a=a.split\(""\);([A-za-z0-9_$]+)\..*\\}
             * Axillary function = var " + auxFuncName + "\\s*=\\s*\\{(.*\\n*){0,3}\\}\\};
             */

            if (index != -1) {
                String jsUrlPattern = "\"PLAYER_JS_URL\":\"([A-za-z0-9/.]+)\"";
                Pattern pattern = Pattern.compile(jsUrlPattern);
                Matcher matcher = pattern.matcher(html);
                if (matcher.find()) {
                    StringBuilder functions = new StringBuilder();
                    String playerJs = CommonUtility.getHtmlString("https://www.youtube.com" + Objects.requireNonNull(matcher.group(1)).replace("\\/", "/"));
                    Pattern decoderFunc = Pattern.compile("([A-za-z0-9_$]{2,3})=function\\(a\\)\\{a=a.split\\(\"\"\\);([A-za-z0-9_$]+)\\..*\\}");//"=([A-za-z0-9_]+)\\(decodeURIComponent\\([.\\w]+\\)\\)");
                    Matcher m = decoderFunc.matcher(playerJs);
                    String auxFuncName = "";
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
                    context.setOptimizationLevel(-1);
                    context.evaluateString(scope, functions.toString(), "script", 1, null);
                }
            }


            if (index != -1) {
                decoderFunction = (Function) scope.get(decodeFunctionName, scope);
                streamingData.initObject(new StreamingData.Decoder() {
                    @Override
                    public String decode(String signature) {
                        return (String) decoderFunction.call(context, scope, scope, new Object[]{signature});
                    }
                });
            } else streamingData.initObject(null);

            VideoData videoData = moshi.adapter(VideoData.class).fromJson(object.getString("videoDetails"));
            videoData.setChannelThumbnail(channelThumbnail);

            end = SystemClock.currentThreadTimeMillis();
            Log.d("YOUTUBE_EXTRACTOR", "extract : " + (end - start) / 1000.0 + "s");
            return new VideoDetails(streamingData, videoData);

        } catch (Exception e) {
            throw new ExtractionException(e.toString());
        }
    }

    public void extract(String videoId, Callback callback) {
        Executors.newSingleThreadExecutor().execute(() -> {
            try {
                VideoDetails videoDetails = extract(videoId);
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



    public interface Callback {
        void onSuccess(VideoDetails videoDetails);

        void onError(ExtractionException e);
    }
}
