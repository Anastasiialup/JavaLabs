package com.education.ztu;

import java.io.FileReader;
import java.io.IOException;

public class ReportReader {
    public static void readReport() {
        try {
            FileReader reader = new FileReader("directory_for_files/purchase_report.txt");
            int character;
            while ((character = reader.read()) != -1) {
                System.out.print((char) character);
            }
            reader.close();
            System.out.println("\nReport read successfully.");
        } catch (IOException e) {
            System.out.println("Error while reading the report: " + e.getMessage());
        }
    }
}
