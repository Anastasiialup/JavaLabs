package com.education.ztu;

import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть ціле позитивне число:");
        int num = scanner.nextInt();

        // Обчислення і виведення суми цифр введеного числа
        System.out.println("Сума цифр: " + sumOfDigits(num)); // Виклик методу sumOfDigits і виведення результату
    }

    // Метод для обчислення суми цифр числа
    public static int sumOfDigits(int num) {
        int sum = 0; // Ініціалізація змінної для зберігання суми цифр
        while (num != 0) { // Цикл, поки num не дорівнює 0
            sum += num % 10; // Додавання останньої цифри до суми
            num /= 10; // Вилучення останньої цифри з числа
        }
        return sum; // Повернення суми цифр
    }
}
