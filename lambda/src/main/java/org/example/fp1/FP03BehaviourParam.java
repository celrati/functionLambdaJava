package org.example.fp1;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class FP03BehaviourParam {


    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7);
        //filterAndPrint(numbers, x -> x % 2 == 0);
        //filterAndPrint(numbers, x -> x % 2 == 1);

        mapAndPrint(numbers, x -> x * x, Collectors.toList());

    }

    private static void mapAndPrint(List<Integer> numbers, Function<Integer,
            Integer> function, Collector<? super Integer, ? extends Object, ? extends List<Object>> collect) {
        List<Object> n =  numbers.stream()
                .map(function)
                .collect(collect);
    }
    private static void filterAndPrint(List<Integer> numbers,  Predicate<? super Integer> predicate) {
        numbers.stream()
                .filter(predicate)
                .forEach(System.out::println);
    }


}
