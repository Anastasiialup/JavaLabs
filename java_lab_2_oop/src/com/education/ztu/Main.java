package com.education.ztu;

public class Main {
    public static void main(String[] args) {
        // Створюємо об'єкти класів Person, Student, Teacher, Employee
        Student student = new Student("Katy", "Pookie", 20, Gender.MALE, Location.KIEV, "Computer Science", "ZTU", 2);
        Teacher teacher = new Teacher("Lida", "Something", 40, Gender.FEMALE, Location.VINNYTSYA, "Mathematics", "ZTU", new Car("Toyota"));
        Employee employee = new Employee("Kiril", "Yabluko", 35, Gender.MALE, Location.ZHYTOMYR, "Tech Corp", "Developer", new Car("BMW"));

        // Демонстрація роботи методів класу Person і його нащадків
        student.sayName();
        teacher.sayName();
        employee.sayName();

        student.getOccupation();
        teacher.getOccupation();
        employee.getOccupation();

        System.out.println("Number of students: " + Student.showCounter());
        System.out.println("Number of teachers: " + Teacher.showCounter());
        System.out.println("Number of employees: " + Employee.showCounter());

        // Виклик статичних методів класу Operation
        int[] numbers = {2, 5, 8, 10};
        System.out.println("Addition: " + Operation.addition(numbers));
        System.out.println("Subtraction: " + Operation.subtraction(numbers));
        System.out.println("Multiplication: " + Operation.multiplication(numbers));
        System.out.println("Division: " + Operation.division(numbers));
        System.out.println("Average: " + Operation.average(numbers));
        System.out.println("Maximum: " + Operation.maximum(numbers));
        System.out.println("Minimum: " + Operation.minimum(numbers));

        // Демонстрація використання enum Location
        for (Location location : Location.values()) {
            System.out.println(location);
        }

        // Перевірка оператора instanceof
        if (student instanceof Person) {
            System.out.println("student is an instance of Person");
        }
    }
}
