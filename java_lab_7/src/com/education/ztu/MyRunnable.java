package com.education.ztu;

class MyRunnable implements Runnable {

    @Override
    public void run() {
        try {
            for (int i = 0; i <= 10000; i++) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("Розрахунок завершено!!!");
                    return; // Завершуємо роботу потоку, якщо він перерваний
                }

                // Друк чисел, що діляться на 10 без залишку
                if (i % 10 == 0) {
                    System.out.println(Thread.currentThread().getName() + " - Число: " + i);
                }
            }
        } catch (Exception e) {
            System.out.println(Thread.currentThread().getName() + " було перервано.");
        }
    }

    public static void main(String[] args) {
        // Створюємо три потоки, що використовують MyRunnable
        Thread thread1 = new Thread(new MyRunnable(), "Thread-1");
        Thread thread2 = new Thread(new MyRunnable(), "Thread-2");
        Thread thread3 = new Thread(new MyRunnable(), "Thread-3");

        // Запускаємо потоки
        thread1.start();
        thread2.start();
        thread3.start();

        try {
            // Затримка головного потоку на 2 секунди
            Thread.sleep(2000);

            // Перериваємо всі три потоки
            thread1.interrupt();
            thread2.interrupt();
            thread3.interrupt();

        } catch (InterruptedException e) {
            System.out.println("Головний потік був перерваний.");
        }
    }
}
