package org.example.fp1;

import java.util.List;
import java.util.function.*;

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


    }



}
