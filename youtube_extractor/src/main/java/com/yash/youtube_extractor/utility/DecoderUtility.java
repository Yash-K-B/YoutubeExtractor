package com.yash.youtube_extractor.utility;

import android.net.Uri;
import android.util.Log;

import com.yash.youtube_extractor.builders.UriBuilder;
import com.yash.youtube_extractor.models.Decoder;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class DecoderUtility {
    private static final String TAG = "DecoderUtility";

    private DecoderUtility() {}

    public static String decodeCipher(String encodedCipher, Decoder decoder) {
        if (decoder == null) return "";
        Map<String, String> queryParams = new HashMap<>();
        for (String param : encodedCipher.split("&", 3)) {
            String[] splits = param.split("=", 2);
            queryParams.put(splits[0], splits.length > 1 ? splits[splits.length - 1] : "");
        }
        String encodedUrl = queryParams.get("url");
        if (encodedUrl == null)
            return null;
        String url = Uri.decode(encodedUrl.replace("\\/", "/"));
        String paramKey = Uri.decode(queryParams.get("sp"));
        String signature = Uri.decode(queryParams.get("s"));
        return String.format(Locale.US, "%s&%s=%s", url, paramKey, Uri.encode(decoder.decodeSignature(signature)));
    }

    public static String decodeSignature(String url, Decoder decoder) {
        if (decoder == null) return "";
        Uri uri = Uri.parse(url);
        String signature = Uri.decode(uri.getQueryParameter("sig"));
        return UriBuilder.from(url).replaceParam("sig", Uri.encode(decoder.decodeSignature(signature))).build();
    }

    public static String decodeThrottle(String url, Decoder decoder) {
        if (decoder == null || url == null) return url;
        Log.i(TAG, "decodeThrottle: Before : "+ url);
        Uri uri = Uri.parse(url);
        String parameter = Uri.decode(uri.getQueryParameter("n"));
        if(parameter == null || parameter.isEmpty())
            return url;
        String decodedThrottle = decoder.decodeThrottle(parameter);
        Log.d(TAG, "Parameter : " + parameter + " Decoded Val: " + decodedThrottle + " : mime : " + uri.getQueryParameter("mime"));
        String s = UriBuilder.from(url).replaceParam("n", Uri.encode(decodedThrottle)).build();
        Log.i(TAG, "decodeThrottle: After : "+ s);

        Log.i(TAG, "decodeThrottle: Diff : " + !parameter.equals(Uri.encode(decodedThrottle)));
        return s;
    }

    public static String getUrl(String url, String signatureCipher, Decoder decoder) {
        if (signatureCipher != null && decoder != null) {
            url = (decodeCipher(signatureCipher, decoder));
        }
        return decodeThrottle(url, decoder);
    }
}
