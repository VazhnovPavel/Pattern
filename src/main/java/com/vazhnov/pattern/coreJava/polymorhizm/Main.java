package com.vazhnov.pattern.coreJava.polymorhizm;

public class Main {
    public static void main(String[] args) {
        // Создание объекта класса Dog
        Animal dog = new Dog();
        // Вызов метода makeSound() для объекта dog
        dog.makeSound(); // Выводит: Dog barks

        // Создание объекта класса Cat
        Animal cat = new Cat();
        // Вызов метода makeSound() для объекта cat
        cat.makeSound(); // Выводит: Cat meows
    }
}