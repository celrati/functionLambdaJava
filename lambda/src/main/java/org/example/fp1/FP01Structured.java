package org.example.fp1;

import java.util.List;

public class FP01Structured {

    public static void printAllNumbersInListStructured(List<Integer> list) {
        for(Integer number: list) {
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        // print all numbers in list
        printAllNumbersInListStructured(List.of(1,2,3,4,5));

    }
}
