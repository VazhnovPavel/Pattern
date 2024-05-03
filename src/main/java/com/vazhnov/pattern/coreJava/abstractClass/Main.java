package com.vazhnov.pattern.coreJava.abstractClass;

public class Main {
    public static void main(String[] args) {
        Animal dog = new Dog();
        dog.makeSound(); // Выводит: Dog barks
        dog.eat(); // Выводит: Animal is eating
    }
}