package com.education.ztu;

public class Operation {
    // Статичний метод для додавання
    public static int addition(int... numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

    // Статичний метод для віднімання
    public static int subtraction(int... numbers) {
        if (numbers.length == 0) return 0;
        int result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            result -= numbers[i];
        }
        return result;
    }

    // Статичний метод для множення
    public static int multiplication(int... numbers) {
        int result = 1;
        for (int number : numbers) {
            result *= number;
        }
        return result;
    }

    // Статичний метод для ділення
    public static float division(int... numbers) {
        if (numbers.length == 0 || numbers[1] == 0) return 0;
        float result = (float) numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] != 0) {
                result /= numbers[i];
            } else {
                System.out.println("Division by zero is not allowed!");
                return 0;
            }
        }
        return result;
    }

    // Статичний метод для обчислення середнього значення
    public static float average(int... numbers) {
        if (numbers.length == 0) return 0;
        return (float) addition(numbers) / numbers.length;
    }

    // Статичний метод для знаходження максимального числа
    public static int maximum(int... numbers) {
        if (numbers.length == 0) return Integer.MIN_VALUE;
        int max = numbers[0];
        for (int number : numbers) {
            if (number > max) {
                max = number;
            }
        }
        return max;
    }

    // Статичний метод для знаходження мінімального числа
    public static int minimum(int... numbers) {
        if (numbers.length == 0) return Integer.MAX_VALUE;
        int min = numbers[0];
        for (int number : numbers) {
            if (number < min) {
                min = number;
            }
        }
        return min;
    }
}
