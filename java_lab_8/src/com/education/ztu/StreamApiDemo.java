package com.education.ztu;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApiDemo {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Laptop", "Apple", 1500.0, 5),
                new Product("Smartphone", "Samsung", 800.0, 10),
                new Product("Shoes", "Nike", 120.0, 50),
                new Product("Watch", "Casio", 250.0, 30),
                new Product("Tablet", "Apple", 600.0, 15)
        );

        // Завдання 4a: Отримати всі бренди
        System.out.println("Brands:");
        products.stream()
                .map(Product::getBrand) // Отримуємо значення brand для кожного продукту
                .distinct() // Унікальні бренди
                .forEach(System.out::println);

        // Завдання 4b: Отримати 2 товари з ціною менше тисячі
        System.out.println("\nProducts with price < 1000:");
        products.stream()
                .filter(product -> product.getPrice() < 1000) // Фільтруємо продукти за умовою ціна < 1000
                .limit(2) // Обмежуємо вибір до 2 товарів
                .forEach(System.out::println);

        // Завдання 4c: Отримати суму всіх видів товарів на складі
        int totalCount = products.stream()
                .map(Product::getCount) // Отримуємо кількість кожного товару
                .reduce(0, Integer::sum); // Сумуємо всі кількості
        System.out.println("\nTotal count of products: " + totalCount);

        // Завдання 4d: Згрупувати товари по бренду
        System.out.println("\nProducts grouped by brand:");
        Map<String, List<Product>> groupedByBrand = products.stream()
                .collect(Collectors.groupingBy(Product::getBrand)); // Групуємо товари за брендом
        groupedByBrand.forEach((brand, productList) -> {
            System.out.println(brand + ": " + productList); // Виводимо бренд та його товари
        });

        // Завдання 4e: Відсортувати товари за зростанням ціни та повернути масив
        System.out.println("\nProducts sorted by price:");
        List<Product> sortedByPrice = products.stream()
                .sorted(Comparator.comparingDouble(Product::getPrice)) // Сортуємо за ціною
                .collect(Collectors.toList()); // Перетворюємо в список
        sortedByPrice.forEach(System.out::println);

        // Завдання 5: Посилання на методи та конструктори
        System.out.println("\nUsing method references:");
        products.stream()
                .map(Product::toString) // Використовуємо метод toString для кожного продукту
                .forEach(System.out::println);

        // Завдання 6: Optional для пошуку максимуму
        System.out.println("\nFind max value from array:");
        Integer[] numbers = {2, 10, 15, 7, 22};
        Optional<Integer> maxNumber = Arrays.stream(numbers)
                .max(Integer::compareTo); // Знаходимо максимальне число
        System.out.println("Max value: " + maxNumber.orElseGet(() -> {
            System.out.println("No numbers present.");
            return -1;
        }));

        // Приклад для порожнього масиву
        Integer[] emptyArray = {};
        String result = Arrays.stream(emptyArray)
                .max(Integer::compareTo) // Знаходимо максимум
                .map(String::valueOf) // Перетворюємо на рядок
                .orElse("Числа відсутні"); // Значення за замовчуванням
        System.out.println("Max value (empty array): " + result);
    }
}

// Клас Product
class Product {
    private String name;
    private String brand;
    private double price;
    private int count;

    public Product(String name, String brand, double price, int count) {
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    // Перевизначений метод toString для зручного виводу об'єкта
    @Override
    public String toString() {
        return String.format("%s (%s) - $%.2f, count: %d", name, brand, price, count);
    }
}
