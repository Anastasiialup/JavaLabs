package com.education.ztu;

import java.lang.annotation.*;
import java.lang.reflect.Method;

// Оголошення анотації CustomAnnotation
@Retention(RetentionPolicy.RUNTIME) // Анотація буде доступна на етапі виконання
@Target(ElementType.METHOD) // Анотація застосована тільки до методів
@interface CustomAnnotation {
    String value() default "Default Value"; // Створення параметра анотації з дефолтним значенням
    int version() default 1; // Створення параметра анотації з дефолтним значенням
}

// Головний клас, де буде використовуватись рефлексія для отримання анотацій
public class AnnotationDemo {
    public static void main(String[] args) throws Exception {
        // Отримуємо метод 'annotatedMethod' з класу AnnotatedClass
        Method method = AnnotatedClass.class.getMethod("annotatedMethod");

        // Перевіряємо, чи є на цьому методі анотація CustomAnnotation
        if (method.isAnnotationPresent(CustomAnnotation.class)) {
            // Якщо анотація є, отримуємо її
            CustomAnnotation annotation = method.getAnnotation(CustomAnnotation.class);

            // Виводимо значення параметрів анотації
            System.out.println("Annotation value: " + annotation.value());  // Виведе "Custom Value"
            System.out.println("Annotation version: " + annotation.version());  // Виведе 2
        }
    }
}

// Клас, у якому метод має анотацію CustomAnnotation
class AnnotatedClass {
    // Застосовуємо анотацію до методу
    @CustomAnnotation(value = "Custom Value", version = 2)
    public void annotatedMethod() {
        System.out.println("This is an annotated method.");
    }
}
