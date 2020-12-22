package ru.imatveev;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

public class Quicksort implements ISort {
    public <T> Collection<T> sort(Collection<T> collection, Comparator<T> comparator) {
        if (collection == null || collection.isEmpty()) return collection;

        Iterator<T> iterator = collection.iterator();
        T first = iterator.next();
        iterator.remove();
        Collection<T> smaller = new ArrayList<>();
        Collection<T> bigger = new ArrayList<>();
        for (T next : collection) {
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
        return null;// TODO: 23/12/20
    }
}
