package com.education.ztu;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Створення об'єкта Scanner для зчитування даних з консолі

        // Запит користувача на введення першого цілого числа
        System.out.println("Введіть перше ціле число:");
        int number1 = scanner.nextInt(); // Зчитування першого цілого числа з консолі

        // Запит користувача на введення другого цілого числа
        System.out.println("Введіть друге ціле число:");
        int number2 = scanner.nextInt(); // Зчитування другого цілого числа з консолі

        // Обчислення суми двох чисел
        int sum = number1 + number2; // Додавання обох чисел і збереження результату в змінній sum

        // Виведення результату на екран
        System.out.println("Сума: " + sum); // Виведення суми двох чисел
    }
}
