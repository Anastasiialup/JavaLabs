package com.education.ztu;

import java.io.*;

public class FileCopyExample {

    public static void main(String[] args) {
        // Шляхи до вихідних файлів
        String textSourceFile = "sourcetext.txt";
        String imageSourceFile = "sourceimage.png";

        // Шляхи до цільових файлів
        String textDestinationFile = "sourcetextcopy.txt";
        String imageDestinationFile = "sourceimagecopy.png";

        // Створюємо вихідні файли, якщо вони не існують
        createFileIfNotExist(textSourceFile);
        createFileIfNotExist(imageSourceFile);

        // Створюємо файли для копії, якщо їх не існує
        createFileIfNotExist(textDestinationFile);
        createFileIfNotExist(imageDestinationFile);

        // Копіюємо вміст текстового файлу
        copyTextFile(textSourceFile, textDestinationFile);

        // Копіюємо вміст зображення
        copyImageFile(imageSourceFile, imageDestinationFile);
    }

    // Метод для створення файлу, якщо він не існує
    private static void createFileIfNotExist(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            try {
                if (file.createNewFile()) {
                    System.out.println("Файл " + fileName + " був успішно створений.");
                }
            } catch (IOException e) {
                System.out.println("Помилка при створенні файлу " + fileName + ": " + e.getMessage());
            }
        }
    }

    // Метод для копіювання текстового файлу
    private static void copyTextFile(String sourceFile, String destinationFile) {
        try (
                BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFile))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine(); // Додаємо новий рядок після кожного запису
            }
            System.out.println("Текстовий файл був успішно скопійований в " + destinationFile);
        } catch (IOException e) {
            System.out.println("Помилка при копіюванні текстового файлу: " + e.getMessage());
        }
    }

    // Метод для копіювання зображення
    private static void copyImageFile(String sourceFile, String destinationFile) {
        try (
                FileInputStream fileInputStream = new FileInputStream(sourceFile);
                FileOutputStream fileOutputStream = new FileOutputStream(destinationFile)
        ) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = fileInputStream.read(buffer)) > 0) {
                fileOutputStream.write(buffer, 0, length);
            }
            System.out.println("Зображення було успішно скопійоване в " + destinationFile);
        } catch (IOException e) {
            System.out.println("Помилка при копіюванні зображення: " + e.getMessage());
        }
    }
}
