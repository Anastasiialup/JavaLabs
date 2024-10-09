package com.education.ztu;

public abstract class Person implements Human {
    private int age;
    private String firstname;
    private String lastname;
    private Gender gender;
    private Location location;
    protected String fullInfo;

    private static int counter = 0; // статичний лічильник створених екземплярів

    // Конструктор за замовчуванням
    public Person() {
        this.firstname = "Default";
        this.lastname = "Name";
        this.age = 0;
        this.gender = Gender.MALE;
        this.location = Location.KIEV;
        counter++;
    }

    // Конструктор з аргументами
    public Person(String firstname, String lastname, int age, Gender gender, Location location) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.gender = gender;
        this.location = location;
        counter++;
    }

    // Геттери та сеттери
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public static int showCounter() {
        return counter;
    }

    // Методи з інтерфейсу Human
    @Override
    public void sayAge() {
        System.out.println("I am " + age + " years old.");
    }

    @Override
    public void sayGender() {
        System.out.println("I am " + gender);
    }

    @Override
    public void sayLocation() {
        System.out.println("I live in " + location);
    }

    @Override
    public void sayName() {
        System.out.println("My name is " + firstname + " " + lastname);
    }

    // Абстрактний метод, який треба буде перевизначити в похідних класах
    public abstract void getOccupation();
}
