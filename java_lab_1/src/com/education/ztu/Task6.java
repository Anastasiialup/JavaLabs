package com.education.ztu;

import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть кількість елементів в масиві:");
        int n = scanner.nextInt();

        int[] fibonacci = new int[n];
        int[] reverseFibonacci = new int[n];

        // Заповнення масиву Фібоначчі
        fibonacci[0] = 1;
        if (n > 1) {
            fibonacci[1] = 1;
        }
        for (int i = 2; i < n; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }

        // Заповнення зворотнього масиву
        for (int i = 0; i < n; i++) {
            reverseFibonacci[i] = fibonacci[n - 1 - i];
        }

        // Виведення масиву Фібоначчі
        System.out.println("Масив Фібоначчі:");
        for (int i : fibonacci) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Виведення зворотнього масиву
        System.out.println("Зворотній масив Фібоначчі:");
        for (int i : reverseFibonacci) {
            System.out.print(i + " ");
        }
    }
}
