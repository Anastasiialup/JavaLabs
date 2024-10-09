package com.education.ztu;

public class Employee extends Person {
    private String company;
    private String position;
    private Car car;

    private static int counter = 0;

    public Employee(String firstname, String lastname, int age, Gender gender, Location location, String company, String position, Car car) {
        super(firstname, lastname, age, gender, location);
        this.company = company;
        this.position = position;
        this.car = car;
        counter++;
    }

    @Override
    public void getOccupation() {
        System.out.println("I am an employee.");
    }

    public static int showCounter() {
        return counter;
    }
}
