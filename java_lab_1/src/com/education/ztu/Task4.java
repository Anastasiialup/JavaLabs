package com.education.ztu;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть перше число:");
        int num1 = scanner.nextInt();

        System.out.println("Введіть друге число:");
        int num2 = scanner.nextInt();

        // Обчислення і виведення найбільшого спільного дільника
        System.out.println("Найбільший спільний дільник: " + gcd(num1, num2)); // Виклик методу gcd і виведення результату
    }

    // Метод для обчислення найбільшого спільного дільника (НСД) двох чисел
    public static int gcd(int a, int b) {
        // Використання алгоритму Евкліда для обчислення НСД
        while (b != 0) { // Цикл, поки b не дорівнює 0
            int temp = b; // Зберігаємо значення b в тимчасову змінну
            b = a % b; // Обчислюємо нове значення b
            a = temp; // Присвоюємо a значення тимчасової змінної
        }
        return a; // Повертаємо найбільший спільний дільник
    }
}
