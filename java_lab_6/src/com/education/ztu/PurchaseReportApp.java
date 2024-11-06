package com.education.ztu;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class PurchaseReportApp {

    private static final String DIRECTORY_PATH = "directory_for_files";
    private static final String FILE_PATH = DIRECTORY_PATH + "/purchase_report.txt";

    public static void main(String[] args) {
        // Перевірка наявності папки для файлів
        File directory = new File(DIRECTORY_PATH);
        if (!directory.exists()) {
            directory.mkdirs(); // Створення папки, якщо вона не існує
        }

        // Формуємо звіт про покупки
        String report = generatePurchaseReport();

        // Записуємо звіт у файл
        writeReportToFile(report);

        // Читаємо звіт з файлу і виводимо на консоль
        readReportFromFile();
    }

    // Метод для генерації звіту про покупки
    private static String generatePurchaseReport() {
        // Вибір локалі (можна змінити на французьку або іншу)
        Locale selectedLocale = new Locale("en", "US");
        ResourceBundle bundle = ResourceBundle.getBundle("data", selectedLocale);

        // Дата та час форматуємо
        String date = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(new Date());

        // Товари
        Object[][] items = {
                {1, "Jeans", "Women's Clothing", 1500.78},
                {2, "Skirt", "Women's Clothing", 1000.56},
                {3, "Tie", "Men's Clothing", 500.78}
        };

        double total = 0;
        StringBuilder report = new StringBuilder();

        // Формуємо звіт
        report.append(bundle.getString("date")).append(": ").append(date).append("\n");
        report.append("===========================================\n");
        report.append(String.format("%-3s %-10s %-15s %-10s\n", "Item No", "Item Name", "Category", "Price"));
        report.append("===========================================\n");

        // Додаємо інформацію про кожен товар
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(selectedLocale);
        for (Object[] item : items) {
            report.append(String.format("%-3d %-10s %-15s %-10s\n", item[0], item[1], item[2], currencyFormat.format(item[3])));
            total += (double) item[3];
        }

        // Додаємо загальну суму
        report.append("===========================================\n");
        report.append(bundle.getString("total")).append(": ").append(currencyFormat.format(total));

        return report.toString();
    }

    // Метод для запису звіту в файл
    private static void writeReportToFile(String report) {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            writer.write(report);
            System.out.println("Report written to file successfully.");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    // Метод для читання звіту з файлу
    private static void readReportFromFile() {
        try (FileReader reader = new FileReader(FILE_PATH)) {
            int character;
            System.out.println("Reading report from file:");
            while ((character = reader.read()) != -1) {
                System.out.print((char) character);
            }
            System.out.println();
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
    }
}
