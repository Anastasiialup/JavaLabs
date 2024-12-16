package com.education.ztu;

import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        // Завдання 2: Власний функціональний інтерфейс Printable
        // Використання лямбда-виразу для реалізації методу print()
        Printable printable = () -> System.out.println("Hello from Printable interface!");
        printable.print();

        // Завдання 3a: Predicate для перевірки, чи можна рядок привести до числа
        // Лямбда-вираз для перевірки, чи рядок є числом
        Predicate<String> isNumeric = str -> {
            try {
                Double.parseDouble(str); // Перетворюємо рядок у число
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        };

        String testString1 = "123.45";
        String testString2 = "NotANumber";

        System.out.println("Is numeric (123.45): " + isNumeric.test(testString1));
        System.out.println("Is numeric (NotANumber): " + isNumeric.test(testString2));

        // Додаткова перевірка: чи рядок не порожній
        Predicate<String> nonEmpty = str -> !str.isEmpty();

        // Поєднуємо дві перевірки за допомогою методу and()
        System.out.println("String is non-empty and numeric (123.45): " +
                nonEmpty.and(isNumeric).test(testString1));
        System.out.println("String is non-empty and numeric (empty string): " +
                nonEmpty.and(isNumeric).test(""));

        // Завдання 3b: Consumer для повідомлень
        Consumer<String> startMessage = str -> System.out.println(str + " Пара почалася о 8:30.");
        Consumer<String> endMessage = str -> System.out.println(str + " Пара закінчилася о 9:50.");

        // Об'єднуємо два Consumer за допомогою методу andThen()
        startMessage.andThen(endMessage).accept("Інформатика:");

        // Завдання 3c: Supplier для виводу тексту у верхньому регістрі
        Supplier<String> upperCaseMessage = () -> "Приклад тексту у верхньому регістрі".toUpperCase();
        System.out.println(upperCaseMessage.get());

        // Завдання 3d: Function для обчислення добутку чисел у рядку
        Function<String, Integer> multiplyNumbers = str -> {
            String[] numbers = str.split("\\s+"); // Розділяємо рядок на числа
            int product = 1;
            for (String num : numbers) {
                product *= Integer.parseInt(num);
            }
            return product;
        };

        String numberString = "2 3 4";
        System.out.println("Product of numbers (2 3 4): " + multiplyNumbers.apply(numberString));
    }
}

@FunctionalInterface
interface Printable {
    void print(); // Метод для реалізації, що не приймає параметрів і нічого не повертає
}
