package org.example.fp1;

import java.util.List;
import java.util.function.*;

public class FP04 {


    public static void main(String[] args) {

        // x -> boolean
        Predicate<Integer> isEvenPredicate = x -> x % 2 == 0;
        // int -> int
        Function<Integer, Integer> squareFunction = x -> x * x;
        // int -> string
        Function<Integer, String> stringPutputFunction = x -> x + "";
        // int -> void
        Consumer<Integer> printerConsumer = x -> System.out.println(x);
        // (int, int) -> int
        BinaryOperator<Integer> sumBinaryOperator = (x, y) -> x + y;
        // void -> int
        Supplier<Integer> randomIntegerSupplier = () -> 2;
        // int -> int // the same type for the input output
        UnaryOperator<Integer> unaryOperator = x -> x + 3;
        int i = randomIntegerSupplier.get();

        // (int, string) -> boolean
        BiPredicate<Integer, String> biPredicate = (number, str) -> {
            return number < 10 && str.length() > 10;
        };
        System.out.println(biPredicate.test(22, "helloWorldAgain"));

        // (int, string) -> string
        BiFunction<Integer, String, String> biFunction = (number, str) -> {
            return number + " " + str;
        };
        System.out.println(biFunction.apply(10, "hello"));

        // (string, String) -> void
        BiConsumer<String, String> biConsumer = (str, str2) -> {
            System.out.println(str+str2);
        };
        biConsumer.accept("h","j");





    }



}
