package com.yash.youtube_extractor.models;

public interface Decoder {
    String decodeSignature(String signature);

    String decodeThrottle(String throttle);
}