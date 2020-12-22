package ru.imatveev;

import org.junit.jupiter.api.Test;
import ru.imatveev.algorithm.Bubblesort;
import ru.imatveev.algorithm.Quicksort;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class SortTests {
    private final List<Integer> collection = Stream
            .generate(() -> new Random().nextInt(10))
            .limit(20)
            .collect(Collectors.toList());

    private final Integer[] array = Stream
            .generate(() -> new Random().nextInt(10))
            .limit(20)
            .toArray(Integer[]::new);

    List<ISort> sortList = new ArrayList<>() {{
        this.add(new Quicksort());
        this.add(new Bubblesort());
    }};

    @Test
    public void test() {
        System.out.println(collection.toString());
        Comparator<Integer> comparator = Comparator.comparingInt(n -> n);

        sortList
                .stream()
                .peek(iSort -> System.out.println(iSort.getClass().getSimpleName()))
                .map(iSort -> iSort.sort(collection, comparator))
                .peek(System.out::println)
                .forEach(
                        sorted -> {
                            assertTrue(isSortedBy(sorted, comparator), sorted.toString());
                            assertEquals(sorted.size(), collection.size(), sorted.toString());
                        }
                );
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
