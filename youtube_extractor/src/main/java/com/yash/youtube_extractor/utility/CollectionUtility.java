package com.yash.youtube_extractor.utility;

import com.yash.youtube_extractor.interfaces.YFunction;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class CollectionUtility {
    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static <K, V> boolean isEmpty(Map<K, V> map) {
        return map == null || map.isEmpty();
    }

    public static <I, V> String join(List<I> items, YFunction<I, V> function, Character delimiter) {
        StringBuilder builder = new StringBuilder();
        for (I item : items) {
            V value = function.apply(item);
            if (builder.length() > 0)
                builder.append(delimiter).append(value);
            else builder.append(value);
        }
        return builder.toString();
    }
}
