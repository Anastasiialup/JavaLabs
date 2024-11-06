package com.education.ztu;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class DateExample {
    public static void main(String[] args) {
        // Дата та час початку лабораторної
        LocalDateTime labStartTime = LocalDateTime.of(2024, Month.NOVEMBER, 4, 10, 0, 0);

        // Виведення дня тижня, дня року, місяця, року, годин, хвилин, секунд
        System.out.println("День тижня: " + labStartTime.getDayOfWeek());
        System.out.println("День року: " + labStartTime.getDayOfYear());
        System.out.println("Місяць: " + labStartTime.getMonth());
        System.out.println("Рік: " + labStartTime.getYear());
        System.out.println("Години: " + labStartTime.getHour());
        System.out.println("Хвилини: " + labStartTime.getMinute());
        System.out.println("Секунди: " + labStartTime.getSecond());

        // Перевірка, чи рік високосний
        System.out.println("Рік високосний: " + Year.isLeap(labStartTime.getYear()));

        // Поточний час
        LocalDateTime currentTime = LocalDateTime.now();

        // Порівняння дат
        System.out.println("Поточна дата після початку лабораторної: " + currentTime.isAfter(labStartTime));
        System.out.println("Поточна дата перед початком лабораторної: " + currentTime.isBefore(labStartTime));

        // Зміна значень дати та часу
        LocalDateTime modifiedDateTime = labStartTime.plusDays(2).minusHours(3).plusMinutes(15);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        System.out.println("Змінена дата та час: " + modifiedDateTime.format(formatter));
    }
}
