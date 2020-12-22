package ru.imatveev.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class CollectionUtil {
    @SuppressWarnings("unchecked")
    public static <T> T[] toArray(Collection<T> collection) {
        return (T[]) collection.toArray();
    }

    public static <T> Collection<T> toCollection(T[] array) {
        return new ArrayList<>(Arrays.asList(array));
    }
}
