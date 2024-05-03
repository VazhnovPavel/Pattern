package com.vazhnov.pattern.coreJava.objectOfMassiv;
public class Main {
    public static void main(String[] args) {
        // Создаем массив объектов типа Person
        Person[] people = new Person[3];
        people[0] = new Person("Alice", 25);
        people[1] = new Person("Bob", 30);
        people[2] = new Person("Charlie", 35);

        // Выводим информацию о каждом человеке в массиве
        for (Person person : people) {
            System.out.println("Name: " + person.getName() + ", Age: " + person.getAge());
        }
    }
}