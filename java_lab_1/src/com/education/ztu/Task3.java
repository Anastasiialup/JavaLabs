package com.education.ztu;

public class Task3 {
    public static void main(String[] args) {
        // Перевірка, чи є аргументи командного рядка
        if (args.length > 0) {
            StringBuilder result = new StringBuilder();
            // Цикл для проходження через всі аргументи
            for (int i = 0; i < args.length; i++) {
                result.append(args[i]); // Додавання аргументу до результату
                // Додавання пробілу між аргументами, якщо це не останній аргумент
                if (i < args.length - 1) {
                    result.append(" ");
                }
            }
            // Виведення зібраного рядка на екран
            System.out.println(result.toString()); // Виведення результату
        }
    }
}

