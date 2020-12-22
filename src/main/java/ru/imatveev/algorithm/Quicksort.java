package ru.imatveev.algorithm;

import ru.imatveev.ISort;

import java.util.*;

import static ru.imatveev.util.CollectionUtil.toArray;
import static ru.imatveev.util.CollectionUtil.toCollection;

public class Quicksort implements ISort {
    public <T> Collection<T> sort(Collection<T> collection, Comparator<T> comparator) {
        if (collection == null || collection.isEmpty()) return collection;
        List<T> collection1 = new ArrayList<>(collection);

        Iterator<T> iterator = collection1.iterator();
        T first = iterator.next();
        iterator.remove();
        Collection<T> smaller = new ArrayList<>();
        Collection<T> bigger = new ArrayList<>();
        for (T next : collection1) {
            if (comparator.compare(next, first) <= 0) {
                smaller.add(next);
            } else {
                bigger.add(next);
            }
        }
        smaller = sort(smaller, comparator);
        bigger = sort(bigger, comparator);

        Collection<T> result = new ArrayList<>(smaller);
        result.add(first);
        result.addAll(bigger);
        return result;
    }

    @Override
    public <T> T[] sort(T[] array, Comparator<T> comparator) {
        return toArray(sort(toCollection(array), comparator));
    }
}
