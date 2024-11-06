package com.education.ztu;

public class MyThread extends Thread {

    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("Потік у стані RUNNING: " + this.getName());
        for (int i = 0; i < 100; i++) {
            System.out.println("Я люблю програмувати!!! " + (i + 1));
        }
        System.out.println("Потік завершив роботу: " + this.getName());
    }

    public static void main(String[] args) {
        // Створюємо екземпляр класу MyThread
        MyThread myThread = new MyThread("InitialThread");

        // Виводимо інформацію про потік перед запуском
        System.out.println("Потік у стані NEW: " + myThread.getName());
        System.out.println("Ім'я потоку: " + myThread.getName());
        System.out.println("Пріоритет потоку: " + myThread.getPriority());
        System.out.println("Чи є потік демоном: " + myThread.isDaemon());
        System.out.println("Чи живий потік: " + myThread.isAlive());

        // Змінюємо ім'я і пріоритет потоку
        myThread.setName("MyProgrammingThread");
        myThread.setPriority(Thread.MAX_PRIORITY);
        System.out.println("Оновлене ім'я потоку: " + myThread.getName());
        System.out.println("Оновлений пріоритет потоку: " + myThread.getPriority());

        // Запускаємо потік
        myThread.start();

        try {
            // Використовуємо join(), щоб дочекатися завершення потоку
            myThread.join();
        } catch (InterruptedException e) {
            System.out.println("Потік було перервано.");
        }

        // Виводимо інформацію про головний потік
        Thread mainThread = Thread.currentThread();
        System.out.println("Ім'я головного потоку: " + mainThread.getName());
        System.out.println("Пріоритет головного потоку: " + mainThread.getPriority());

        // Перевіряємо стан потоку після завершення
        System.out.println("Чи живий потік: " + myThread.isAlive());
        System.out.println("Потік у стані TERMINATED: " + myThread.getName());
    }
}
