package com.education.ztu;

import com.education.ztu.game.*;

public class Main {
    public static void main(String[] args) {
        try {
            // Створення учасників
            Schoolar schoolar1 = new Schoolar("Ivan", 13);
            Schoolar schoolar2 = new Schoolar("Mariya", 15);
            Team<Schoolar> scollarTeam = new Team<>("Dragon");
            scollarTeam.addNewParticipant(schoolar1);
            scollarTeam.addNewParticipant(schoolar2);

            // Клонування
            Team<Schoolar> clonedTeam = Team.deepClone(scollarTeam);
            System.out.println("Original team: " + scollarTeam);
            System.out.println("Cloned team: " + clonedTeam);

            // Зміна в оригінальній команді
            schoolar1.setName("IvanUpdated");
            System.out.println("After updating the original team:");
            System.out.println("Original team: " + scollarTeam);
            System.out.println("Cloned team remains unchanged: " + clonedTeam);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
