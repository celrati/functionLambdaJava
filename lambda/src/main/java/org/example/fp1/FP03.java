package org.example.fp1;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FP03 {


    public static void main(String[] args) {
        predicates();
    }

    public static void predicates() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7);

        Predicate<? super Integer> predicateImpair = x -> x % 2 == 1;
        // equals implementation
        Predicate<? super Integer> predicateImpair2 = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer % 2 == 1;
            }
        };


        Function<Integer, Integer> functionOne = x -> x * x;
        Function<Integer, ?> functionOne2 = new Function<Integer, Object>() {
            @Override
            public Object apply(Integer integer) {
                return integer * integer;
            }
        };


        Consumer<?> consumerOne = System.out::println;

        Consumer<Integer> consumerOne2 = x -> new Consumer<Integer>() {
            @Override
            public void accept(Integer o) {
                System.out.println(o);
            }
        };

        BinaryOperator<Integer> biSum = (x, y) -> x + y;
        BinaryOperator<Integer> biSum2 = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return integer + integer2;
            }
        };


        numbers.stream()
                .filter(predicateImpair)
                .map(functionOne)
                .reduce(0, biSum);
                //.forEach(consumerOne);
    }

}
