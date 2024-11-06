package com.education.ztu;

public class StringMethods {

    // Метод, що приймає рядок і виконує зазначені операції
    public static void processString(String input) {
        // Роздрукувати останній символ рядка
        System.out.println("Останній символ: " + input.charAt(input.length() - 1));

        // Перевірити, чи закінчується рядок підрядком "!!!"
        System.out.println("Закінчується на '!!!': " + input.endsWith("!!!"));

        // Перевірити, чи починається рядок підрядком "I learn "
        System.out.println("Починається з 'I learn ': " + input.startsWith("I learn "));

        // Перевірити, чи містить рядок підрядок "Java"
        System.out.println("Містить 'Java': " + input.contains("Java"));

        // Знайти позицію підрядка “Java” у рядку
        System.out.println("Позиція 'Java': " + input.indexOf("Java"));

        // Замінити всі символи "а" на "о"
        String replacedString = input.replace('a', 'o');
        System.out.println("Замінити 'a' на 'o': " + replacedString);

        // Перетворити рядок на верхній регістр
        System.out.println("Верхній регістр: " + input.toUpperCase());

        // Перетворити рядок на нижній регістр
        System.out.println("Нижній регістр: " + input.toLowerCase());

        // Вирізати рядок "Java"
        int start = input.indexOf("Java");
        if (start != -1) {
            String cutString = input.substring(0, start) + input.substring(start + 4);
            System.out.println("Вирізати 'Java': " + cutString);
        } else {
            System.out.println("'Java' не знайдено для вирізання.");
        }
    }

    public static void main(String[] args) {
        String text = "I learn Java!!!";
        processString(text);
    }
}
