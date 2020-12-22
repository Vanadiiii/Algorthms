package ru.imatveev;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertTrue;

public class SortTests {
    private final List<Integer> collection = Stream
            .generate(() -> new Random().nextInt(10))
            .limit(20)
            .collect(Collectors.toList());

    private final Integer[] array = Stream
            .generate(() -> new Random().nextInt(10))
            .limit(20)
            .toArray(Integer[]::new);

    private final Quicksort quicksort = new Quicksort();
    private final Bubblesort bubblesort = new Bubblesort();

    @Test
    public void quickSortTest() {
        System.out.println(collection.toString());
        Comparator<Integer> comparator = Comparator.comparingInt(n -> n);
        Collection<Integer> sorted1 = quicksort.sort(collection, comparator);
//        Collection<Integer> sorted2 = bubblesort.sort(collection, comparator);

        assertTrue(sorted1.toString(), isSortedBy(sorted1, comparator));
//        assertTrue(sorted2.toString(), isSortedBy(sorted2, comparator));
        System.out.println(Arrays.toString(bubblesort.sort(array, comparator)));
    }

    public <T extends Comparable<T>> boolean isSortedBy(Collection<T> collection, Comparator<T> comparator) {
        if (collection == null || collection.isEmpty()) return true;
        Iterator<T> iterator = collection.iterator();
        T previous = null;
        while (iterator.hasNext()) {
            T next = iterator.next();
            if (previous != null && comparator.compare(next, previous) < 0) {
                return false;
            }
            previous = next;
        }
        return true;
    }
}
