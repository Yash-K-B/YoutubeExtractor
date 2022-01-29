package com.yash.youtube_extractor.utility;

import java.util.Collection;
import java.util.Collections;

public class CollectionUtility {
    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }
}
