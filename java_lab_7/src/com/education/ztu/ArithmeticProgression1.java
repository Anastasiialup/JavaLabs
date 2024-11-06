package com.education.ztu;

public class ArithmeticProgression1 implements Runnable {
    private static int result = 1;
    private static final int STEP = 1;
    private static final int LIMIT = 100;
    private static final Object lock = new Object(); // Об'єкт для синхронізації

    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                if (result > LIMIT) {
                    break;
                }
                System.out.print(result + " ");
                result += STEP;
            }

            try {
                Thread.sleep(200); // Затримка на 0,2 секунди
            } catch (InterruptedException e) {
                System.out.println("Потік було перервано.");
            }
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new ArithmeticProgression(), "Thread-1");
        Thread thread2 = new Thread(new ArithmeticProgression(), "Thread-2");
        Thread thread3 = new Thread(new ArithmeticProgression(), "Thread-3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}