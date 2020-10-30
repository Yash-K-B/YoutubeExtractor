package com.yash.youtube_extractor;

import android.os.SystemClock;
import android.util.Log;

import com.google.gson.Gson;
import com.yash.youtube_extractor.models.StreamingData;

import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.ScriptableObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Extractor {
    private static final String TAG = "Extractor";
    public static final String BASE_URL = "https://www.youtube.com/watch?v=";
    Context context;
    ScriptableObject scope;
    Function decoderFunction;

    public Extractor() {
    }

    public StreamingData extract(String videoId) {
        String url = BASE_URL + videoId;
        boolean isCipherEnabled;
        try {
            long start,end;
            start = SystemClock.currentThreadTimeMillis();
            Document doc = Jsoup.connect(url).get();
            String decodeFunctionName = "";
            context = Context.enter();
            scope = context.initStandardObjects();
            String htmlPage = doc.toString();
            Pattern urlEncoded = Pattern.compile("\"useCipher\":([A-za-z]+)");
            Matcher useCipherMatcher = urlEncoded.matcher(htmlPage);
            if (useCipherMatcher.find()) {
                isCipherEnabled = useCipherMatcher.group(1).equalsIgnoreCase("true");
                //Function name regex = =([A-za-z0-9_]+)\(decodeURIComponent\([.\w]+\)\)
                //Function regex = Yu\s*=\s*function\(\s*a\s*\)\{\s*a=a.split\(\"\"\);([A-za-z0-9_]+).*};
                //Axillary function = var Xu\s*=\s*{.*};
                if (isCipherEnabled) {
                    String jsUrlPattern = "\"PLAYER_JS_URL\":\"([A-za-z0-9/.]+)\"";
                    Pattern pattern = Pattern.compile(jsUrlPattern);
                    Matcher matcher = pattern.matcher(htmlPage);
                    if (matcher.find()) {
                        StringBuilder functions = new StringBuilder();
                        String playerJs = getString("https://www.youtube.com" + matcher.group(1).replace("\\/", "/"));
                        Pattern decoderFunc = Pattern.compile("([A-za-z0-9_]{2,3})=function\\(a\\)\\{a=a.split\\(\\\"\\\"\\);([A-za-z0-9_]+)\\..*\\}");//"=([A-za-z0-9_]+)\\(decodeURIComponent\\([.\\w]+\\)\\)");
                        Matcher m = decoderFunc.matcher(playerJs);
                        String auxFuncName = "";
                        if (m.find()) {
                            functions.append("var ").append(m.group(0)).append(";");
                            decodeFunctionName = m.group(1);
                            auxFuncName = m.group(2);
                        }
                        Pattern auxFunc = Pattern.compile("var " + auxFuncName + "\\s*=\\s*\\{(.*\\n*){0,3}\\}\\};");
                        Matcher auxMatcher = auxFunc.matcher(playerJs);
                        if (auxMatcher.find()) {
                            functions.append(auxMatcher.group(0));
                        }
                        context.setOptimizationLevel(-1);
                        context.evaluateString(scope, functions.toString(), "script", 1, null);
                    }
                }

                String script = doc.select("#player-wrap").html();
                int stIndex = script.indexOf("\"player_response\":\"{");
                int enIndex = script.indexOf("}\"");
                String result = script.substring(stIndex + 19, enIndex) + "}";
                result = result.replace("\\\\u0026", "&");
                result = result.replace("\\\"", "\"");
                result = result.replace("\\\\", "\\");
                JSONObject object = new JSONObject(result);
                Gson gson = new Gson();
                StreamingData streamingData = gson.fromJson(object.getString("streamingData"), StreamingData.class);
                if(isCipherEnabled){
                    decoderFunction = (Function) scope.get(decodeFunctionName, scope);
                    streamingData.initObject(new StreamingData.Decoder() {
                        @Override
                        public String decode(String signature) {
                            return (String) decoderFunction.call(context, scope, scope, new Object[]{signature});
                        }
                    });
                } else streamingData.initObject(null);

                end = SystemClock.currentThreadTimeMillis();
                Log.d("YOUTUBE_EXTRACTOR","extract : "+(end-start)/1000.0+"s");
                return streamingData;
            }
            return null;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void extract(String videoId, Callback callback) {
        callback.onSuccess(extract(videoId));
    }


    String getString(String url) {
        StringBuilder result = new StringBuilder();
        try {
            URL webUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) webUrl.openConnection();
            connection.getDoInput();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            int numChar = -1;
            char[] buffer = new char[4096];
            while ((numChar = bufferedReader.read(buffer)) != -1) {
                result.append(buffer, 0, numChar);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }


    public interface Callback {
        void onSuccess(StreamingData streamingData);
    }
}


//            File file = new File(context.getFilesDir(),"html.txt");
//            FileOutputStream fileOutputStream = new FileOutputStream(file);
//            DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);
//            dataOutputStream.writeBytes(s);
//            dataOutputStream.close();
//            fileOutputStream.close();
