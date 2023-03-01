package org.example.fp1;

import java.util.List;

public class FP02Structured {


    public static void main(String[] args) {
      List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
      int sum = addListStructured(numbers);
      int sum2 = addListFunctional(numbers);
      System.out.println(sum);
      System.out.println(sum2);
    }

    private static int sum(int aggregate, int nextNumber) {
        return aggregate + nextNumber;
    }
    private static int addListFunctional(List<Integer> numbers) {
        // needs the accumalot and the combiner "sum"
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
