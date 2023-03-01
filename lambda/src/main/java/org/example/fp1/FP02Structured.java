package org.example.fp1;

import java.util.List;

public class FP02Structured {


    public static void main(String[] args) {
      List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
      int sum = addListStructured(numbers);
      int sum2 = addListFunctional(numbers);
      System.out.println(sum);
      System.out.println(sum2);

      exercices();
      distinctExercice();
      sortingExercice();
    }

    public static void sortingExercice() {
        // we can so it for strings also..
        List<Integer> numbers = List.of(0, 1,2,3,4,5,6, 0, 4 ,5,6);
        numbers.stream()
                .sorted()
                .forEach(System.out::print);
        // by default the comparator is the Comparator.naturalOrder()
        // we have also the Comparator.reverseOrder()
        // custom comparator
        // .sorted(Comparator.comparing(str -> str.length())).forEach(showing here)
    }
    public static void distinctExercice() {
        List<Integer> numbers = List.of(0, 1,2,3,4,5,6, 0, 4 ,5,6);
        numbers.stream()
                .distinct()
                .forEach(System.out::print);
    }

    public static void exercices() {
        List<Integer> numbers = List.of(0, 1,2,3,4,5,6);
        int s = numbers.stream()
                .map(number -> number * number)
              //  .reduce(0, (x, y) -> x + y);
                .reduce(0, Integer::sum);

        int s2 = numbers.stream()
                .filter(number -> number % 2 == 1)
                .reduce(0, Integer::sum);

        System.out.println(s);
        System.out.println(s2);
    }

    private static int sum(int aggregate, int nextNumber) {
        return aggregate + nextNumber;
    }
    private static int addListFunctional(List<Integer> numbers) {
        // needs the accumalator and the combiner "sum"
        return numbers.stream()
                //.reduce(0, FP02Structured::sum);
                .reduce(0, (x,y) -> x + y);
    }

    private static int addListStructured(List<Integer> numbers) {
        int sum = 0;
        for(int number: numbers) {
            sum += number;
        }
        return sum;
    }
}
