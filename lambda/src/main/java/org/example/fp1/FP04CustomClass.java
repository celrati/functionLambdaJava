package org.example.fp1;

import java.util.Comparator;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

class Course {
    private String name;

    public Course(String name, String category, int reviewScore, int noOfStudents) {
        this.name = name;
        this.category = category;
        this.reviewScore = reviewScore;
        this.noOfStudents = noOfStudents;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", reviewScore=" + reviewScore +
                ", noOfStudents=" + noOfStudents +
                '}';
    }

    private String category;
    private int reviewScore;
    private int noOfStudents;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(int reviewScore) {
        this.reviewScore = reviewScore;
    }

    public int getNoOfStudents() {
        return noOfStudents;
    }

    public void setNoOfStudents(int noOfStudents) {
        this.noOfStudents = noOfStudents;
    }
}
public class FP04CustomClass {


    public static void main(String[] args) {
        List<Course> courses = List.of(
                new Course("Spring", "Frameword", 98, 20000),
                new Course("Spring Boot", "Frameword", 95, 18000),
                new Course("API", "Microservices", 97, 22000),
                new Course("Microservices", "Microservices", 96, 25000),
                new Course("FullStack", "FullStack", 91, 14000),
                new Course("AWS", "Cloud", 92, 21000),
                new Course("Azure", "Cloud", 99, 21000),
                new Course("Docker", "Cloud", 92, 20000),
                new Course("Kubernetes", "Cloud", 91, 20000)

        );
        // allMatch, noneMatch, anyMatch


        Predicate<Course> coursePredicate = course -> course.getReviewScore() > 90;
        Predicate<Course> coursePredicate2 = course -> course.getReviewScore() > 95;
        Predicate<Course> coursePredicate3 = course -> course.getReviewScore() < 90;


        // all match verify if all the elements satisfy a predicate
        System.out.println(courses.stream().allMatch(coursePredicate));
        // none satisfy the predicate
        System.out.println(courses.stream().noneMatch(coursePredicate3));
        // if there is one that satisfy the predicate
        System.out.println(courses.stream().anyMatch(coursePredicate));

        // sorting
        Comparator<Course> comparingByNoOfStudentsIncreasing = Comparator.comparing(Course::getNoOfStudents);
        Comparator<Course> comparingByNoOfStudentsDecreasing = Comparator.comparing(Course::getNoOfStudents).reversed();



        System.out.println(courses.stream()
                .sorted(comparingByNoOfStudentsDecreasing)
                .limit(5) // limit to 5 elements..
                .takeWhile(course -> course.getReviewScore() >= 95) // take while we satisfy the predicate
                .dropWhile(course -> course.getReviewScore() >= 95) // drop while we satisfy the predicate)
                .collect(Collectors.toList()));

        System.out.println(courses.stream()
                .sorted(comparingByNoOfStudentsDecreasing)
                .skip(3) // skip the first 3 elements..
                .collect(Collectors.toList()));


        Comparator<Course> comparingByNoOfStudentsAndReviews = Comparator
                .comparing(Course::getNoOfStudents)
                .thenComparing(Course::getReviewScore)
                .reversed();

        //max, min returns Optional
        courses.stream().max(Comparator.comparing(Course::getNoOfStudents));


        // .sum() to get the sum of all ints
        // .average
        // .count

        // group by

        courses.stream()
                .collect(Collectors.groupingBy(Course::getCategory));

        courses.stream()
                .collect(Collectors.groupingBy(Course::getCategory, Collectors.counting()));

        courses.stream()
                .collect(Collectors.groupingBy(Course::getCategory,
                        Collectors.maxBy(Comparator.comparing(Course::getReviewScore))));

        courses.stream()
                .collect(Collectors.groupingBy(Course::getCategory,
                        Collectors.mapping(Course::getName, Collectors.toList())));


    }




}
