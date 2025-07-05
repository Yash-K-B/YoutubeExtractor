package com.yash.youtube_extractor.decoders;

import lombok.Builder;
import lombok.Getter;

public interface YParser {
    YParseResponse parse(String playerJs);


    @Builder
    @Getter
    class YParseResponse {
        private String decoderFunctionName;
        private String throttleFunctionName;
        private String script;

        public boolean hasDecoderFunction() {
            return decoderFunctionName != null;
        }

        public boolean hasThrottleFunction() {
            return throttleFunctionName != null;
        }

        public static YParseResponse empty() {
            return YParseResponse.builder().build();
        }
    }
}
