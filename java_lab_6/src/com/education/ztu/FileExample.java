package com.education.ztu;

import java.io.File;

public class FileExample {

    public static void main(String[] args) {
        // 1. Створення нової папки
        File innerDirectory = new File("inner_directory");
        if (innerDirectory.mkdir()) {
            System.out.println("Папка створена: " + innerDirectory.getAbsolutePath());
        } else {
            System.out.println("Не вдалося створити папку.");
        }

        // 2. Виведення абсолютного шляху створеної папки
        System.out.println("Абсолютний шлях створеної папки: " + innerDirectory.getAbsolutePath());

        // 3. Виведення ім'я батьківської директорії
        File parentDirectory = innerDirectory.getParentFile();
        System.out.println("Батьківська директорія: " + (parentDirectory != null ? parentDirectory.getAbsolutePath() : "Це коренева директорія проєкту"));

        // 4. Створення двох текстових файлів всередині папки
        createFile(innerDirectory, "file1.txt");
        createFile(innerDirectory, "file2.txt");

        // 5. Видалення одного файлу
        File fileToDelete = new File(innerDirectory, "file1.txt");
        if (fileToDelete.delete()) {
            System.out.println("Файл " + fileToDelete.getName() + " був успішно видалений.");
        } else {
            System.out.println("Не вдалося видалити файл " + fileToDelete.getName());
        }

        // 6. Переіменування папки, якщо нова назва ще не існує
        File renamedDirectory = new File("renamed_inner_directory");
        if (!renamedDirectory.exists()) {
            if (innerDirectory.renameTo(renamedDirectory)) {
                System.out.println("Папка була переіменована в: " + renamedDirectory.getAbsolutePath());
            } else {
                System.out.println("Не вдалося переіменувати папку.");
            }
        } else {
            System.out.println("Папка з ім'ям " + renamedDirectory.getName() + " вже існує.");
        }

        // 7. Виведення списку файлів та папок у папці "directory_for_files", їх розмір та тип (файл, папка)
        File directoryForFiles = new File("directory_for_files");
        if (directoryForFiles.exists() && directoryForFiles.isDirectory()) {
            File[] files = directoryForFiles.listFiles();
            if (files != null && files.length > 0) {
                System.out.println("Список файлів і папок у директорії " + directoryForFiles.getAbsolutePath() + ":");
                for (File file : files) {
                    String type = file.isDirectory() ? "Папка" : "Файл";
                    System.out.println(type + ": " + file.getName() + ", Розмір: " + file.length() + " байт");
                }
            } else {
                System.out.println("У директорії немає файлів або папок.");
            }
        } else {
            System.out.println("Директорія " + directoryForFiles.getAbsolutePath() + " не існує.");
        }
    }

    // Метод для створення файлів всередині вказаної папки
    private static void createFile(File directory, String fileName) {
        File file = new File(directory, fileName);
        try {
            if (file.createNewFile()) {
                System.out.println("Файл " + fileName + " був успішно створений.");
            } else {
                System.out.println("Файл " + fileName + " вже існує.");
            }
        } catch (Exception e) {
            System.out.println("Помилка при створенні файлу " + fileName + ": " + e.getMessage());
        }
    }
}
