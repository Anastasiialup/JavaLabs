package com.education.ztu;

import java.util.Scanner;

public class ReaderPrinterExample {
    private static String sharedData = ""; // Змінна для синхронізації

    public static void main(String[] args) {
        Object lock = new Object();

        // Потік Reader для зчитування введених даних
        Thread readerThread = new Thread(() -> {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                synchronized (lock) {
                    System.out.print("Введіть текст (або 'exit' для завершення): ");
                    sharedData = scanner.nextLine();
                    lock.notify(); // Інформуємо Printer про наявність нових даних

                    if (sharedData.equalsIgnoreCase("exit")) {
                        break; // Завершення, якщо користувач ввів "exit"
                    }

                    try {
                        lock.wait(); // Очікування, поки Printer виведе дані
                        Thread.sleep(1000); // Засипаємо на 1 секунду перед повтором
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            scanner.close();
        });

        // Потік Printer для виведення отриманих даних
        Thread printerThread = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    try {
                        lock.wait(); // Чекаємо нових даних від Reader

                        if (sharedData.equalsIgnoreCase("exit")) {
                            break; // Завершення, якщо введено "exit"
                        }

                        System.out.println("Printer отримав: " + sharedData);
                        lock.notify(); // Інформуємо Reader, що дані виведені
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        readerThread.start();
        printerThread.start();
    }
}
