package com.education.ztu;

public class Task7 {
    public static void main(String[] args) {
        char[] alphabet = new char[26];

        // Заповнення масиву символів латинського алфавіту
        for (int i = 0; i < 26; i++) {
            alphabet[i] = (char) ('A' + i);
        }

        // Виведення символів та їх числових кодів
        for (char letter : alphabet) {
            System.out.println(letter + " ==> " + (int) letter);
        }
    }
}
