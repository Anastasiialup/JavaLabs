package com.education.ztu;

import java.io.*;
import java.nio.file.*;
import java.util.zip.*;

public class ZipArchiveExample {
    public static void main(String[] args) {
        File directory = new File("directory_for_files"); // Папка з файлами для архівування
        File zipFile = new File("directory_for_files.zip"); // Архів

        // Створення архіву та додавання файлів
        try (ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFile))) {
            File[] filesToZip = directory.listFiles();
            if (filesToZip != null) {
                for (File file : filesToZip) {
                    try (FileInputStream fileIn = new FileInputStream(file)) {
                        ZipEntry zipEntry = new ZipEntry(file.getName());
                        zipOut.putNextEntry(zipEntry);

                        byte[] buffer = new byte[1024];
                        int length;
                        while ((length = fileIn.read(buffer)) > 0) {
                            zipOut.write(buffer, 0, length);
                        }
                        zipOut.closeEntry();
                    }
                }
                System.out.println("Файли успішно додані до архіву " + zipFile.getName());
            } else {
                System.out.println("Папка порожня або не існує.");
            }
        } catch (IOException e) {
            System.out.println("Помилка під час архівування файлів: " + e.getMessage());
        }

        // Читання файлів з архіву
        System.out.println("\nСписок файлів в архіві:");
        try (ZipInputStream zipIn = new ZipInputStream(new FileInputStream(zipFile))) {
            ZipEntry entry;
            while ((entry = zipIn.getNextEntry()) != null) {
                System.out.println("Файл: " + entry.getName());
                zipIn.closeEntry();
            }
        } catch (IOException e) {
            System.out.println("Помилка під час читання архіву: " + e.getMessage());
        }
    }
}
