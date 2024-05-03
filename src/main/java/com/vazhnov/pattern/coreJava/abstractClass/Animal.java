package com.vazhnov.pattern.coreJava.abstractClass;

abstract class Animal {
    // Абстрактный метод
    abstract void makeSound();

    // Метод с реализацией по умолчанию
    void eat() {
        System.out.println("Animal is eating");
    }
}
