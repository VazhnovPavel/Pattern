package com.vazhnov.pattern.coreJava.inheritance;
public class Main {
    public static void main(String[] args) {
        // Создание объекта класса Dog
        Dog dog = new Dog();

        // Вызов метода eat() из базового класса
        dog.eat();

        // Вызов метода bark() из подкласса
        dog.bark();
    }
}