package com.education.ztu;

import java.util.Formatter;

public class CheckFormatter {
    public static void main(String[] args) {
        Formatter formatter = new Formatter();

        // Дата та час покупки
        String date = "28.03.2019";
        String time = "13:25:12";

        // Форматування заголовка
        formatter.format("Дата та час покупки: %s %s\n", date, time);
        formatter.format("===========================================\n");
        formatter.format("%-2s %-10s %-15s %-10s\n", "№", "Товар", "Категорія", "Ціна");
        formatter.format("===========================================\n");

        // Форматування рядків для кожного товару
        Object[][] items = {
                {1, "Джинси", "Жіночий одяг", 1500.78},
                {2, "Спідниця", "Жіночий одяг", 1000.56},
                {3, "Краватка", "Чоловічий одяг", 500.78},
                {4, "Сорочка", "Чоловічий одяг", 800.22},
                {5, "Футболка", "Чоловічий одяг", 300.10},
                {6, "Сукня", "Жіночий одяг", 2000.00},
                {7, "Куртка", "Жіночий одяг", 2700.50},
                {8, "Шкарпетки", "Чоловічий одяг", 50.75},
                {9, "Капелюх", "Чоловічий одяг", 400.00},
                {10, "Шарф", "Чоловічий одяг", 150.30}
        };

        double total = 0;
        for (Object[] item : items) {
            formatter.format("%-2d %-10s %-15s %-10.2f ₴\n", item[0], item[1], item[2], item[3]);
            total += (double) item[3];
        }

        // Виведення загальної суми
        formatter.format("===========================================\n");
        formatter.format("Разом: %.2f ₴\n", total);

        // Виведення результату на екран
        System.out.println(formatter);

        // Закриття formatter
        formatter.close();
    }
}
