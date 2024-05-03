package com.vazhnov.pattern.coreJava.polymorhizm;

// Подкласс, наследующий родительский класс
class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("Dog barks");
    }
}