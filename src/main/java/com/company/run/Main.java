package com.company.run;

import java.util.Comparator;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        List<Integer> l1 = Stream.of(1, 2, 3, 4, 5, 10, 20)
                .filter(x -> x % 2 == 0)
                .sorted(Comparator.reverseOrder())
                .limit(2)
                .collect(Collectors.toList());

        List<Integer> l2 = Stream.of(1, 2, 3, 4, 5, 10, 20)
                .filter(x -> x % 2 == 0)
                .sorted(Comparator.reverseOrder())
                .limit(2)
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
//
        List<Integer> l3 = Stream.of(1, 2, 3)
                .map(a -> a * a)
                .collect(Collectors.toList());

        List<Integer> l4 = Stream.of(1, 2, 3, 4, 5)
                .filter(a -> a % 2 == 0)
                .collect(Collectors.toList());

        List<Integer> l5 = Stream.of(1, 2, 3, 4, 5, 10, 20)
                .filter(a -> a % 2 == 0)
                .limit(2)
                .collect(Collectors.toList());

        //
        List<Integer> l6 = Stream.of(1, 2, 3, 4, 5, 10, 20)
                .filter(x -> x % 2 == 1)
                .sorted(Comparator.reverseOrder())
                .limit(2)
                .collect(Collectors.toList());
        //

        final List<Integer> l7 = Stream.of(1, 2, 3, 4, 5)
                .collect(Collectors.filtering(a -> a % 2 == 0, Collectors.toList()));

        System.out.println();
        l6.forEach(System.out::println);
    }
}
