package com.education.ztu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Запитуємо логін
        System.out.print("Enter login: ");
        String login = scanner.nextLine();

        // Запитуємо пароль
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        // Запитуємо підтвердження пароля
        System.out.print("Confirm password: ");
        String confirmPassword = scanner.nextLine();

        // Виконуємо перевірку введених даних
        boolean result = CredentialsChecker.checkCredentials(login, password, confirmPassword);
        System.out.println("Credentials are valid: " + result);
    }
}
