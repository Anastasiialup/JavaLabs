package com.education.ztu;

public class Student extends Person {
    private int course;
    private String speciality;
    private String university;

    private static int counter = 0;

    public Student(String firstname, String lastname, int age, Gender gender, Location location, String speciality, String university, int course) {
        super(firstname, lastname, age, gender, location);
        this.speciality = speciality;
        this.university = university;
        this.course = course;
        counter++;
    }

    @Override
    public void getOccupation() {
        System.out.println("I am a student.");
    }

    public static int showCounter() {
        return counter;
    }
}
