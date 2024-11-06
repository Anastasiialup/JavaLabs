package com.education.ztu;

import java.io.*;

public class RandomAccessFileExample {

    public static void main(String[] args) {
        // Шлях до текстового файлу
        String fileName = "products.txt";

        // Створюємо файл, якщо його не існує
        createFileIfNotExist(fileName);

        // Дописуємо товар в кілька місць в файлі
        addProductToFile(fileName, "Товар 1: Холодильник - 5000 грн.");
        addProductToFile(fileName, "Товар 2: Телевізор - 8000 грн.");
        addProductToFile(fileName, "Товар 3: Смартфон - 3000 грн.");
    }

    // Метод для створення файлу, якщо він не існує
    private static void createFileIfNotExist(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            try {
                if (file.createNewFile()) {
                    System.out.println("Файл " + fileName + " був успішно створений.");
                }
            } catch (IOException e) {
                System.out.println("Помилка при створенні файлу " + fileName + ": " + e.getMessage());
            }
        }
    }

    // Метод для додавання товару в файл в певне місце
    private static void addProductToFile(String fileName, String product) {
        try (RandomAccessFile file = new RandomAccessFile(fileName, "rw")) {
            // Знаходимо першу порожню лінію або додаємо товар в кінець файлу
            file.seek(file.length()); // Переміщаємо курсор в кінець файлу
            file.writeBytes(product + "\n");
            System.out.println("Товар був доданий: " + product);
        } catch (IOException e) {
            System.out.println("Помилка при додаванні товару в файл: " + e.getMessage());
        }
    }
}
