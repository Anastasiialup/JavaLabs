package com.education.ztu;

import java.util.NavigableSet;
import java.util.TreeSet;

public class ProductSetDemo {
    public static void main(String[] args) {
        TreeSet<Product> productSet = new TreeSet<>((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()));

        // Додавання продуктів
        productSet.add(new Product("Laptop", 1500.0, "Electronics"));
        productSet.add(new Product("Smartphone", 800.0, "Electronics"));
        productSet.add(new Product("Shoes", 120.0, "Fashion"));
        productSet.add(new Product("Watch", 250.0, "Accessories"));
        productSet.add(new Product("Tablet", 600.0, "Electronics"));

        // Методи роботи з множиною
        System.out.println("First product: " + productSet.first());
        System.out.println("Last product: " + productSet.last());
        System.out.println("Head set (< 800): " + productSet.headSet(new Product("Dummy", 800.0, "")));
        System.out.println("Sub set (120 - 800): " + productSet.subSet(new Product("Dummy", 120.0, ""), new Product("Dummy", 800.0, "")));
        System.out.println("Tail set (>= 600): " + productSet.tailSet(new Product("Dummy", 600.0, "")));

        System.out.println("Ceiling (>= 700): " + productSet.ceiling(new Product("Dummy", 700.0, "")));
        System.out.println("Floor (<= 1000): " + productSet.floor(new Product("Dummy", 1000.0, "")));
        System.out.println("Higher (> 800): " + productSet.higher(new Product("Dummy", 800.0, "")));
        System.out.println("Lower (< 250): " + productSet.lower(new Product("Dummy", 250.0, "")));

        System.out.println("Poll first: " + productSet.pollFirst());
        System.out.println("Poll last: " + productSet.pollLast());

        NavigableSet<Product> descendingSet = productSet.descendingSet();
        System.out.println("Descending set: " + descendingSet);
    }
}
