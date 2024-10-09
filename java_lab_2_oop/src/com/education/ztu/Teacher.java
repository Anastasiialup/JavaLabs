package com.education.ztu;

public class Teacher extends Person {
    private String subject;
    private String university;
    private Car car;

    private static int counter = 0;

    public Teacher(String firstname, String lastname, int age, Gender gender, Location location, String subject, String university, Car car) {
        super(firstname, lastname, age, gender, location);
        this.subject = subject;
        this.university = university;
        this.car = car;
        counter++;
    }

    @Override
    public void getOccupation() {
        System.out.println("I am a teacher.");
    }

    public static int showCounter() {
        return counter;
    }
}
