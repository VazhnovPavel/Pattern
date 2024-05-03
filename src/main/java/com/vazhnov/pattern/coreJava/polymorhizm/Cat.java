package com.vazhnov.pattern.coreJava.polymorhizm;

// Другой подкласс, также наследующий родительский класс
class Cat extends Animal {
    @Override
    void makeSound() {
        System.out.println("Cat meows");
    }
}