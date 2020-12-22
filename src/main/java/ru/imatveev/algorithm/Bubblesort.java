package ru.imatveev.algorithm;

import ru.imatveev.ISort;

import java.util.Collection;
import java.util.Comparator;

import static ru.imatveev.util.CollectionUtil.toArray;
import static ru.imatveev.util.CollectionUtil.toCollection;

public class Bubblesort implements ISort {
    public <T> Collection<T> sort(Collection<T> collection, Comparator<T> comparator) {
        return toCollection(sort(toArray(collection), comparator));
    }

    public <T> T[] sort(T[] array, Comparator<T> comparator) {
        if (array == null || array.length < 2) return array;
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (comparator.compare(array[i + 1], array[i]) < 0) {
                    T swapped = array[i + 1];
                    array[i + 1] = array[i];
                    array[i] = swapped;
                    isSorted = false;
                }
            }
        }
        return array;
    }
}
