package com.yash.youtube_extractor.utility;

import java.util.List;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MapUtility {


    public static Object safeGet(Object object, Integer ...depthIndices) {
        if (object == null) {
            return "";
        }

        if (depthIndices.length == 0) {
            return object;
        }

        Object current = object;

        for (int index : depthIndices) {
            if (current instanceof List<?>) {
                List<?> list = (List<?>) current;
                if (index >= 0 && index < list.size()) {
                    current = list.get(index);
                } else {
                    return "";
                }
            }
        }
        return current;
    }


}
