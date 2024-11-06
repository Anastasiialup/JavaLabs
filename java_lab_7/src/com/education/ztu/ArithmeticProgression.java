package com.education.ztu;

public class ArithmeticProgression implements Runnable {
    // Статична змінна для збереження значення арифметичної прогресії
    private static int result = 1;
    private static final int STEP = 1;
    private static final int LIMIT = 100;

    // Синхронізований метод для обчислення прогресії та виведення результату
    public synchronized void calculateAndPrintProgression() {
        if (result <= LIMIT) {
            System.out.print(result + " ");
            result += STEP;
        }
    }

    @Override
    public void run() {
        while (result <= LIMIT) {
            calculateAndPrintProgression();
            try {
                // Затримка на 0,2 секунди
                Thread.sleep(200);
            } catch (InterruptedException e) {
                System.out.println("Потік було перервано.");
            }
        }
    }

    public static void main(String[] args) {
        // Створюємо три потоки, що використовують клас ArithmeticProgression
        Thread thread1 = new Thread(new ArithmeticProgression(), "Thread-1");
        Thread thread2 = new Thread(new ArithmeticProgression(), "Thread-2");
        Thread thread3 = new Thread(new ArithmeticProgression(), "Thread-3");

        // Запускаємо потоки
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
