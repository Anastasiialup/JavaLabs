package com.education.ztu;

import java.lang.reflect.*;

public class ReflectionDemo {
    public static void main(String[] args) throws Exception {
        // 1. Отримати об'єкт класу Class трьома способами
        // 1.1. Через клас
        Class<MyClass> class1 = MyClass.class;
        // 1.2. Через екземпляр об'єкта
        MyClass instance = new MyClass();
        Class<? extends MyClass> class2 = instance.getClass();
        // 1.3. Через повне ім'я класу
        Class<?> class3 = Class.forName("com.education.ztu.MyClass");

        // 2. Отримати всі поля класу
        System.out.println("Fields:");
        for (Field field : class1.getDeclaredFields()) {
            // Вивести ім'я поля та його тип
            System.out.println(field.getName() + " (" + field.getType() + ")");
        }

        // 3. Отримати всі методи класу
        System.out.println("\nMethods:");
        for (Method method : class1.getDeclaredMethods()) {
            // Вивести ім'я методу та тип, який він повертає
            System.out.println(method.getName() + " (Return type: " + method.getReturnType() + ")");
        }

        // 4. Отримати всі конструктори класу
        System.out.println("\nConstructors:");
        for (Constructor<?> constructor : class1.getDeclaredConstructors()) {
            // Вивести ім'я конструктора
            System.out.println(constructor.getName());
        }

        // 5. Створити екземпляр класу через рефлексію
        // Знаходимо конструктор, який приймає рядок
        Constructor<MyClass> constructor = class1.getConstructor(String.class);
        // Створюємо новий екземпляр з параметром
        MyClass newInstance = constructor.newInstance("Hello Reflection");

        // 6. Викликати метод класу через рефлексію
        // Знаходимо метод "sayHello"
        Method publicMethod = class1.getDeclaredMethod("sayHello");
        // Викликаємо метод на новоствореному екземплярі
        publicMethod.invoke(newInstance);

        // 7. Працювати з приватним полем через рефлексію
        // Знаходимо приватне поле "privateField"
        Field privateField = class1.getDeclaredField("privateField");
        // Даємо доступ до приватного поля
        privateField.setAccessible(true);
        // Змінюємо значення поля
        privateField.set(newInstance, 42);
        // Отримуємо нове значення поля та виводимо його
        System.out.println("Private field value: " + privateField.get(newInstance));
    }
}

class MyClass {
    public String publicField = "Public Field";
    private int privateField;
    public MyClass() {
    }

    // Конструктор з параметром
    public MyClass(String message) {
        System.out.println("Constructor called with message: " + message);
    }

    // Публічний метод
    public void sayHello() {
        System.out.println("Hello from MyClass!");
    }
}
