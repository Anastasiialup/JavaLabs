package com.education.ztu;

import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть кількість елементів в масиві:");
        int n = scanner.nextInt(); // Зчитування кількості елементів

        int[] fibonacci = new int[n]; // Ініціалізація масиву для чисел Фібоначчі
        int[] reverseFibonacci = new int[n]; // Ініціалізація масиву для зворотних чисел Фібоначчі

        // Заповнення масиву чисел Фібоначчі
        fibonacci[0] = 1; // Перший елемент Фібоначчі
        if (n > 1) { // Перевірка, чи масив має більше одного елемента
            fibonacci[1] = 1; // Другий елемент Фібоначчі
        }
        // Обчислення наступних елементів масиву Фібоначчі
        for (int i = 2; i < n; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2]; // Сума двох попередніх елементів
        }

        // Заповнення зворотнього масиву Фібоначчі
        for (int i = 0; i < n; i++) {
            reverseFibonacci[i] = fibonacci[n - 1 - i]; // Копіювання елементів у зворотному порядку
        }

        // Виведення масиву Фібоначчі
        System.out.println("Масив Фібоначчі:");
        for (int i : fibonacci) { // Цикл для перебору елементів масиву Фібоначчі
            System.out.print(i + " "); // Виведення елемента
        }
        System.out.println(); // Перехід на новий рядок

        // Виведення зворотнього масиву Фібоначчі
        System.out.println("Зворотній масив Фібоначчі:");
        for (int i : reverseFibonacci) { // Цикл для перебору елементів зворотнього масиву
            System.out.print(i + " "); // Виведення елемента
        }
    }
}
