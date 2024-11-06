package com.education.ztu;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class InternationalizedCheck {
    public static void main(String[] args) {
        Locale enLocale = new Locale("en", "US");
        Locale frLocale = new Locale("fr", "FR");

        // Вибираємо локаль (спробуйте спочатку англійську, потім французьку)
        Locale selectedLocale = enLocale; // Змініть на frLocale для тесту французької локалі

        ResourceBundle bundle = ResourceBundle.getBundle("data", selectedLocale);

        // Виведення заголовка
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        System.out.println(bundle.getString("date") + ": " + dateFormat.format(new Date()));
        System.out.println("===========================================");
        System.out.printf("%-3s %-10s %-15s %-10s\n", bundle.getString("item_number"), bundle.getString("item_name"), bundle.getString("item_category"), bundle.getString("item_price"));
        System.out.println("===========================================");

        // Товари
        Object[][] items = {
                {1, bundle.getString("jeans"), "Жіночий одяг", 1500.78},
                {2, bundle.getString("skirt"), "Жіночий одяг", 1000.56},
                {3, bundle.getString("tie"), "Чоловічий одяг", 500.78}
        };

        double total = 0;
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(selectedLocale);

        for (Object[] item : items) {
            System.out.printf("%-3d %-10s %-15s %-10s\n", item[0], item[1], item[2], currencyFormat.format((double) item[3]));
            total += (double) item[3];
        }

        // Виведення загальної суми
        System.out.println("===========================================");
        System.out.println(bundle.getString("total") + ": " + currencyFormat.format(total));
    }
}
