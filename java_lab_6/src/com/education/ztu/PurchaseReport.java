package com.education.ztu;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class PurchaseReport {
    private static final String DIRECTORY_PATH = "directory_for_files";
    private static final String FILE_PATH = DIRECTORY_PATH + "/purchase_report.txt";

    // Метод для запису звіту про покупки у файл
    public static void writeReport(String reportContent) {
        // Перевірка і створення папки, якщо вона не існує
        File directory = new File(DIRECTORY_PATH);
        if (!directory.exists()) {
            directory.mkdirs(); // Створює папку
        }

        FileWriter writer = null;
        try {
            writer = new FileWriter(FILE_PATH);
            writer.write(reportContent);
            System.out.println("Report written to file successfully.");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    System.err.println("Error closing writer: " + e.getMessage());
                }
            }
        }
    }

    // Метод для читання звіту про покупки з файлу
    public static void readReport() {
        FileReader reader = null;
        try {
            reader = new FileReader(FILE_PATH);
            int character;
            System.out.println("Reading report from file:");
            while ((character = reader.read()) != -1) {
                System.out.print((char) character);
            }
            System.out.println();
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.err.println("Error closing reader: " + e.getMessage());
                }
            }
        }
    }
}
