package org.example.fp1;

import java.util.List;

public class FP01Functional {

    public static  void print(int i) {
        System.out.println(i);
    }
    public static Boolean isEven(int i) {
        return (i % 2 == 0);
    }
    public static void printAllNumbersInListFunctional(List<Integer> list) {
        list.stream()
                .filter(e -> isEven(e))
                .forEach(FP01Functional::print);

    }
    public static void exercices() {
        List<String> courses = List.of("Spring", "Spring boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");

        courses.stream()
                .filter(course -> course.contains("Spring"))
                .forEach(System.out::println);

        courses.stream()
                .filter(course -> course.length() > 4)
                .forEach(System.out::println);
    }


    public static void main(String[] args) {
        // print all numbers in list
        //printAllNumbersInListFunctional(List.of(1,2,3,4,5));
        exercices();

    }
}
