package ru.imatveev;

import java.util.Collection;
import java.util.Comparator;

public interface ISort {
    <T> Collection<T> sort(Collection<T> collection, Comparator<T> comparator);

    <T> T[] sort(T[] array, Comparator<T> comparator);
}
