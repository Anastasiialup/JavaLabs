package com.education.ztu;

public class Task7 {
    public static void main(String[] args) {
        char[] alphabet = new char[26]; // Ініціалізація масиву символів для латинського алфавіту (26 букв)

        // Заповнення масиву символів латинського алфавіту
        for (int i = 0; i < 26; i++) { // Цикл для перебору всіх букв алфавіту
            alphabet[i] = (char) ('A' + i); // Присвоєння символу, починаючи з 'A'
        }

        // Виведення символів та їх числових кодів
        for (char letter : alphabet) { // Цикл для перебору кожної букви в масиві
            System.out.println(letter + " ==> " + (int) letter); // Виведення букви та її ASCII коду
        }
    }
}
