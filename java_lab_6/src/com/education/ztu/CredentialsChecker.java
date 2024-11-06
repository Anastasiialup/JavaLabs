package com.education.ztu;

public class CredentialsChecker {
    public static boolean checkCredentials(String login, String password, String confirmPassword) {
        try {
            if (!login.matches("[A-Za-z0-9_]+") || login.length() >= 20) {
                throw new WrongLoginException("Login should contain only Latin letters, numbers, or underscores, and be less than 20 characters.");
            }

            if (!password.matches("[A-Za-z0-9_]+") || password.length() >= 20 || !password.equals(confirmPassword)) {
                throw new WrongPasswordException("Password should contain only Latin letters, numbers, or underscores, be less than 20 characters, and match the confirm password.");
            }

            return true; // Credentials are valid

        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }
}
