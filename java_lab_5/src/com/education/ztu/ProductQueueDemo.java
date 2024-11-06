package com.education.ztu;

import java.util.ArrayDeque;
import java.util.Deque;

public class ProductQueueDemo {
    public static void main(String[] args) {
        Deque<Product> productQueue = new ArrayDeque<>();

        // Додавання елементів
        productQueue.offerLast(new Product("Laptop", 1500.0, "Electronics"));
        productQueue.offerLast(new Product("Smartphone", 800.0, "Electronics"));
        productQueue.push(new Product("Tablet", 600.0, "Electronics"));

        // Отримання елементів
        System.out.println("First element (getFirst): " + productQueue.getFirst());
        System.out.println("Last element (peekLast): " + productQueue.peekLast());

        // Видалення елементів
        System.out.println("Removed first element (pop): " + productQueue.pop());
        System.out.println("Removed last element (removeLast): " + productQueue.removeLast());

        // Додавання ще елементів і перевірка черги
        productQueue.offer(new Product("Headphones", 150.0, "Electronics"));
        System.out.println("Queue after adding another element: " + productQueue);
    }
}
