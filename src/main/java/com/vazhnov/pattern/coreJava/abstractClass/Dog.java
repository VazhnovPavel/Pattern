package com.vazhnov.pattern.coreJava.abstractClass;

class Dog extends Animal {
    // Переопределение абстрактного метода
    @Override
    void makeSound() {
        System.out.println("Dog barks");
    }
}