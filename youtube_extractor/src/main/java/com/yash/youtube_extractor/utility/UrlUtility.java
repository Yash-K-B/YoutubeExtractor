package com.yash.youtube_extractor.utility;

import android.net.Uri;

import com.yash.youtube_extractor.builders.UriBuilder;
import com.yash.youtube_extractor.models.AdaptiveFormat;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UrlUtility {

    public static String buildUrl(AdaptiveFormat format, String serverAbrStreamingUrl) {
        Map<String, String> params = new HashMap<>();
        params.put("itag", String.valueOf(format.getItag()));
        params.put("ratebypass", "yes");
        params.put("mime", URLEncoder.encode(format.getMimeType().split(";")[0]));
        params.put("clen", String.valueOf(format.getContentLength()));
        params.put("lmt", format.getLastModified());
        params.put("dur", format.getApproxDurationMs().replaceAll("^(.+?)(.{3})$", "$1.$2"));

        Uri uri = Uri.parse(serverAbrStreamingUrl);
        String sparams = Uri.decode(uri.getQueryParameter("sparams"));
        sparams += String.join(",", params.keySet());
        UriBuilder uriBuilder = UriBuilder.from(serverAbrStreamingUrl).replaceParam("sparams", Uri.encode(sparams));

        for(Map.Entry<String, String> param: params.entrySet()) {
            uriBuilder.appendParamBefore(param.getKey(), param.getValue(), "sparams");
        }
        return uriBuilder.build();
    }

}
