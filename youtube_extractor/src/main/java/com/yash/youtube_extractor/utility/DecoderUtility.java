package com.yash.youtube_extractor.utility;

import android.net.Uri;
import android.util.Log;

import com.yash.youtube_extractor.models.Decoder;
import com.yash.youtube_extractor.models.StreamingData;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
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

    public static String decodeThrottle(String url, Decoder decoder) {
        if (decoder == null) return url;
        Uri uri = Uri.parse(url);
        String parameter = Uri.decode(uri.getQueryParameter("n"));
        String decodedThrottle = decoder.decodeThrottle(parameter);
        Log.d(TAG, "Parameter : " + parameter + " Decoded Val: " + decodedThrottle);
        return url.replace("&n=" + parameter, "&n=" + decodedThrottle);
    }

    public static String getUrl(String url, String signatureCipher, Decoder decoder) {
        if (signatureCipher != null && decoder != null) {
            url = (decodeCipher(signatureCipher, decoder));
        }
        return decodeThrottle(url, decoder);
    }
}
