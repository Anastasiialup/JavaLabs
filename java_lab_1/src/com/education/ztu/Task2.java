package com.education.ztu;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть перше ціле число:");
        int number1 = scanner.nextInt();
        System.out.println("Введіть друге ціле число:");
        int number2 = scanner.nextInt();

        int sum = number1 + number2;
        System.out.println("Сума: " + sum);
    }
}
