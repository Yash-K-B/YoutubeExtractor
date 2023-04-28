package com.yash.youtube_extractor.builders;

import android.net.Uri;
import android.util.Pair;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UriBuilder {
    private final String path;
    private final List<Pair<String, String>> params;
    private final Set<String> keys;

    private UriBuilder(String uri) {
        params = new ArrayList<>();
        keys = new HashSet<>();
        if (uri.contains("?")) {
            String[] query = uri.split("[?]", 2);
            this.path = query[0];
            String[] params = query[1].split("&");
            for (String param : params) {
                String[] part = param.split("=", 2);
                this.params.add(Pair.create(part[0], part.length > 1 ? part[1] : ""));
                this.keys.add(part[0]);
            }
        } else {
            this.path = uri;
        }
    }


    public static UriBuilder from(String uri) {
        return new UriBuilder(uri);
    }

    public UriBuilder appendParam(String key, String value) {
        params.add(Pair.create(key, Uri.encode(value)));
        return this;
    }

    public UriBuilder appendEncodedParam(String key, String value) {
        params.add(Pair.create(key, value));
        return this;
    }

    public UriBuilder replaceParam(String key, String value) {
        boolean isReplaced = false;
        for (int i = 0; i < params.size(); i++) {
            if (params.get(i).first.equals(key)) {
                params.set(i, Pair.create(key, value));
                isReplaced = true;
                break;
            }
        }
        if (!isReplaced) {
            appendParam(key, value);
        }
        return this;
    }

    public UriBuilder appendParamBefore(String key, String value, String beforeKey) {
        if(keys.contains(key))
            return this;

        boolean isInserted = false;
        for (int i = 0; i < params.size(); i++) {
            if (params.get(i).first.equals(beforeKey)) {
                params.add(i, Pair.create(key, Uri.encode(value)));
                isInserted = true;
                break;
            }
        }
        if (!isInserted) {
            appendParam(key, value);
        }
        return this;
    }


    public String build() {
        StringBuilder builder = new StringBuilder();
        for (Pair<String, String> param : params) {
            if (builder.length() > 0)
                builder.append("&");
            builder.append(param.first).append("=").append(param.second);
        }
        return path + "?" + builder;
    }
}
