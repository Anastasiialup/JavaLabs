package com.education.ztu;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo {
    public static void main(String[] args) {
        String text = """
                John Doe, 30, Software Engineer, 5 years, New York, john.doe@example.com, +1-123-456-7890
                Jane Smith, 25, Data Analyst, 2 years, Los Angeles, jane.smith@example.com, +1-987-654-3210
                Mike Johnson, 40, Project Manager, 15 years, Chicago, mike.johnson@example.com, +1-555-444-3333
                Sarah Brown, 28, UX Designer, 4 years, Boston, sarah.brown@example.com, +1-666-777-8888
                """;

        // 1. Знайти всі номери телефонів та email
        Pattern emailPattern = Pattern.compile("\\b[\\w.-]+@[\\w.-]+\\.\\w{2,}\\b");
        Pattern phonePattern = Pattern.compile("\\+\\d-\\d{3}-\\d{3}-\\d{4}");

        // Пошук та виведення email
        System.out.println("Emails:");
        Matcher emailMatcher = emailPattern.matcher(text);
        while (emailMatcher.find()) { // Перебираємо всі знайдені збіги
            System.out.println(emailMatcher.group());
        }

        // Пошук та виведення номерів телефонів
        System.out.println("\nPhone Numbers:");
        Matcher phoneMatcher = phonePattern.matcher(text);
        while (phoneMatcher.find()) { // Перебираємо всі знайдені збіги
            System.out.println(phoneMatcher.group());
        }

        // 2. Змінити формат дат народження
        String textWithDates = """
                John Doe, 20.05.1995
                Jane Smith, 15.09.1998
                """;

        // Заміна формату дат з dd.MM.yyyy на yyyy-MM-dd
        String updatedDates = textWithDates.replaceAll("(\\d{2})\\.(\\d{2})\\.(\\d{4})", "$3-$2-$1");
        System.out.println("\nUpdated Dates:");
        System.out.println(updatedDates);

        // 3. Змінити посади кільком співробітникам
        String updatedPositions = text.replaceAll("Software Engineer", "Senior Software Engineer")
                .replaceAll("Data Analyst", "Data Scientist");
        System.out.println("\nUpdated Positions:");
        System.out.println(updatedPositions);
    }
}
