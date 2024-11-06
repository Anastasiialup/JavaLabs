package com.education.ztu;

import java.util.*;

public class CollectionsDemo {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Laptop", 1500.0, "Electronics"),
                new Product("Smartphone", 800.0, "Electronics"),
                new Product("Shoes", 120.0, "Fashion"),
                new Product("Watch", 250.0, "Accessories"),
                new Product("Tablet", 600.0, "Electronics")
        );

        // Сортування
        Collections.sort(products, Comparator.comparingDouble(Product::getPrice));
        System.out.println("Sorted products: " + products);

        // Двійковий пошук
        int index = Collections.binarySearch(products, new Product("Shoes", 120.0, "Fashion"), Comparator.comparingDouble(Product::getPrice));
        System.out.println("Index of 'Shoes': " + index);

        // Reverse та shuffle
        Collections.reverse(products);
        System.out.println("Reversed products: " + products);

        Collections.shuffle(products);
        System.out.println("Shuffled products: " + products);

        // Fill
        List<Product> copyList = new ArrayList<>(products);
        Collections.fill(copyList, new Product("Default", 0.0, "None"));
        System.out.println("Filled list: " + copyList);

        // Max та min
        Product maxPriceProduct = Collections.max(products, Comparator.comparingDouble(Product::getPrice));
        Product minPriceProduct = Collections.min(products, Comparator.comparingDouble(Product::getPrice));
        System.out.println("Max price product: " + maxPriceProduct);
        System.out.println("Min price product: " + minPriceProduct);

        // Copy
        List<Product> copyOfProducts = new ArrayList<>(Arrays.asList(new Product[products.size()]));
        Collections.copy(copyOfProducts, products);
        System.out.println("Copied list: " + copyOfProducts);

        // Rotate
        Collections.rotate(products, 2);
        System.out.println("Rotated products: " + products);

        // Checked collection
        Collection<Product> checkedCollection = Collections.checkedCollection(new ArrayList<>(products), Product.class);
        System.out.println("Checked collection: " + checkedCollection);

        // Частота
        Product tablet = new Product("Tablet", 600.0, "Electronics");
        int frequency = Collections.frequency(products, tablet);
        System.out.println("Frequency of 'Tablet': " + frequency);
    }
}
