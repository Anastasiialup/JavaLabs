package com.education.ztu;

import com.education.ztu.game.*;
import com.education.ztu.game.AgeComparator;  // Імпорт класу AgeComparator

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        // Створення учасників
        Schoolar schoolar1 = new Schoolar("Ivan", 13);
        Schoolar schoolar2 = new Schoolar("Mariya", 15);
        Student student1 = new Student("Mykola", 20);
        Student student2 = new Student("Viktoria", 21);
        Employee employee1 = new Employee("Andriy", 28);
        Employee employee2 = new Employee("Oksana", 25);

        // Додавання учасників до списку
        List<Participant> participants = new ArrayList<>();
        participants.add(schoolar1);
        participants.add(schoolar2);
        participants.add(student1);
        participants.add(student2);
        participants.add(employee1);
        participants.add(employee2);

        // Вивід учасників до сортування
        System.out.println("Before sorting:");
        for (Participant participant : participants) {
            System.out.println(participant);
        }

        // Сортування за віком
        Collections.sort(participants, new AgeComparator());

        // Вивід учасників після сортування
        System.out.println("\nAfter sorting by age:");
        for (Participant participant : participants) {
            System.out.println(participant);
        }
    }
}
