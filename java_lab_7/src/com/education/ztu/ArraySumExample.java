package com.education.ztu;

import java.util.Random;
import java.util.concurrent.*;

public class ArraySumExample {
    private static final int ARRAY_SIZE = 1_000_000;
    private static final int THREAD_COUNT = 5;
    private static final int[] array = new int[ARRAY_SIZE];

    static {
        Random random = new Random();
        for (int i = 0; i < ARRAY_SIZE; i++) {
            array[i] = random.nextInt(10); // Заповнюємо числами від 0 до 9
        }
    }

    // Однопоточний варіант
    public static long singleThreadSum() {
        long sum = 0;
        for (int value : array) {
            sum += value;
        }
        return sum;
    }

    // Багатопоточний варіант з використанням ExecutorService
    public static long multiThreadSum() throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);
        int chunkSize = ARRAY_SIZE / THREAD_COUNT;
        long totalSum = 0;

        // Локальний клас ArraySumTask
        class ArraySumTask implements Callable<Long> {
            private final int start;
            private final int end;

            public ArraySumTask(int start, int end) {
                this.start = start;
                this.end = end;
            }

            @Override
            public Long call() {
                long sum = 0;
                for (int i = start; i < end; i++) {
                    sum += array[i];
                }
                return sum;
            }
        }

        // Розподіл завдань
        Future<Long>[] futures = new Future[THREAD_COUNT];
        for (int i = 0; i < THREAD_COUNT; i++) {
            int start = i * chunkSize;
            int end = (i == THREAD_COUNT - 1) ? ARRAY_SIZE : start + chunkSize;
            futures[i] = executor.submit(new ArraySumTask(start, end));
        }

        // Збираємо результати
        for (Future<Long> future : futures) {
            totalSum += future.get();
        }

        executor.shutdown();
        return totalSum;
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // Однопоточний запуск
        long startSingleThread = System.currentTimeMillis();
        long singleThreadSum = singleThreadSum();
        long endSingleThread = System.currentTimeMillis();
        System.out.println("Однопоточна сума: " + singleThreadSum + " (Час: " + (endSingleThread - startSingleThread) + " мс)");

        // Багатопоточний запуск
        long startMultiThread = System.currentTimeMillis();
        long multiThreadSum = multiThreadSum();
        long endMultiThread = System.currentTimeMillis();
        System.out.println("Багатопоточна сума: " + multiThreadSum + " (Час: " + (endMultiThread - startMultiThread) + " мс)");
    }
}
