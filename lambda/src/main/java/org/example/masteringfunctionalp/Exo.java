package org.example.masteringfunctionalp;

import java.awt.*;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Exo {
    public static void main(String[] args) {
        exo1();
        //   product <- order -> customer
    }

    public static void exo7() {
        //  Get a list of orders which were ordered on 15-Mar-2021,
        //  log the order records to the console and then return its product list
        List<Order> orders = null;
        orders.stream()
                .filter(o -> o.getOrderDate().equals(LocalDate.of(2021, 3, 15)))
                .peek(System.out::print)
                .flatMap(o -> o.getProducts().stream())
                .distinct()
                .collect(Collectors.toList());
    }
    public static void exo6() {
        //  Get the 3 most recent placed order
        List<Order> orders = null;
        orders.stream()
                .sorted(Comparator.comparing(Order::getDeliveryDate).reversed())
                .limit(3)
                .collect(Collectors.toList());

    }
    public static void exo5() {
        //  Get the cheapest products of “Books” category
        List<Product> products = null;
        products.stream()
                .filter(p -> p.getCategory().equals("Books"))
                .sorted(Comparator.comparing(Product::getPrice).reversed())
                .findFirst();
    }
    public static void exo4() {
        // Obtain a list of products ordered by customer of tier 2 between 01-Feb-2021 and 01-Apr-2021
        List<Order> orders = null;
        orders.stream()
                .filter(o -> o.getCustomer().getTier() == 2)
                .filter(o -> o.getOrderDate().compareTo(LocalDate.of(2021, 2, 1)) >= 0)
                .filter(o -> o.getOrderDate().compareTo(LocalDate.of(2021, 4, 1)) <= 0)
                .flatMap(o -> o.getProducts().stream())
                .distinct()
                .collect(Collectors.toList());

    }
    public static void exo3() {
        //  Obtain a list of product with category = “Toys” and then apply 10% discount
        List<Product> products = null;
        products.stream()
                .filter(p -> p.getCategory().equals("Toys"))
                .forEach(p -> p.setPrice(p.getPrice() * 0.9));


    }
    public static void exo2() {
        //  Obtain a list of order with products belong to category “Baby”
        List<Order> orders = null;
        Predicate<Order> predicateCategory = order -> {
            return order.getProducts()
                    .stream()
                    .anyMatch(product -> product.getCategory().equals("Baby"));
        };

        List<Order> lo = orders.stream()
                .filter(predicateCategory)
                .collect(Collectors.toList());


    }
    public static void exo1() {
        // Obtain a list of products belongs to category “Books” with price > 100
        List<Product> products = null;
        List<Product> lp = products.stream()
                .filter(product -> product.getCategory().equals("Books") && product.getPrice() > 80 )
                .collect(Collectors.toList());

    }
}
