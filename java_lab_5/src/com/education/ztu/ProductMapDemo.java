package com.education.ztu;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ProductMapDemo {
    public static void main(String[] args) {
        Map<String, Product> productMap = new HashMap<>();

        // Додавання продуктів
        productMap.put("Laptop", new Product("Laptop", 1500.0, "Electronics"));
        productMap.put("Smartphone", new Product("Smartphone", 800.0, "Electronics"));
        productMap.put("Shoes", new Product("Shoes", 120.0, "Fashion"));

        // Використання методів HashMap
        System.out.println("Get product by name 'Laptop': " + productMap.get("Laptop"));
        System.out.println("Contains key 'Tablet': " + productMap.containsKey("Tablet"));
        System.out.println("Contains value (Product 'Shoes'): " + productMap.containsValue(new Product("Shoes", 120.0, "Fashion")));

        productMap.putIfAbsent("Watch", new Product("Watch", 250.0, "Accessories"));
        System.out.println("All keys: " + productMap.keySet());
        System.out.println("All values: " + productMap.values());

        Map<String, Product> additionalProducts = new HashMap<>();
        additionalProducts.put("Tablet", new Product("Tablet", 600.0, "Electronics"));
        productMap.putAll(additionalProducts);

        System.out.println("Size of map: " + productMap.size());

        // entrySet
        Set<Map.Entry<String, Product>> entries = productMap.entrySet();
        for (Map.Entry<String, Product> entry : entries) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        productMap.remove("Laptop");
        productMap.clear();
        System.out.println("Map after clear: " + productMap);
    }
}
