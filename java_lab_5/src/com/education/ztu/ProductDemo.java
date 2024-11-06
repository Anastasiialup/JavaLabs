package com.education.ztu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ProductDemo {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();

        // Додавання елементів
        products.add(new Product("Laptop", 1500.0, "Electronics"));
        products.add(new Product("Smartphone", 800.0, "Electronics"));
        products.add(new Product("Shoes", 120.0, "Fashion"));

        // Використання методу addAll
        List<Product> additionalProducts = List.of(
                new Product("Watch", 250.0, "Accessories"),
                new Product("Tablet", 600.0, "Electronics")
        );
        products.addAll(additionalProducts);

        // Використання get та indexOf
        System.out.println("First product: " + products.get(0));
        System.out.println("Index of 'Shoes': " + products.indexOf(new Product("Shoes", 120.0, "Fashion")));

        // Використання listIterator
        Iterator<Product> iterator = products.listIterator();
        while (iterator.hasNext()) {
            System.out.println("Product: " + iterator.next());
        }

        // Використання remove та set
        products.remove(1);
        products.set(1, new Product("Headphones", 150.0, "Electronics"));

        // Використання sort
        products.sort((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()));

        // Використання subList
        List<Product> subList = products.subList(0, 2);
        System.out.println("Sublist: " + subList);

        // Інші методи
        System.out.println("Contains 'Laptop'? " + products.contains(new Product("Laptop", 1500.0, "Electronics")));
        System.out.println("Is empty? " + products.isEmpty());
        System.out.println("Size: " + products.size());

        // Перетворення на масив
        Product[] productsArray = products.toArray(new Product[0]);

        // Очищення
        products.clear();
        System.out.println("Products after clear: " + products);
    }
}
