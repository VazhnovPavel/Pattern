package com.vazhnov.pattern.coreJava.interfaceImpl;
public class Main {
    public static void main(String[] args) {
        // Создание объектов классов Car и Bike
        Car car = new Car();
        Bike bike = new Bike();

        // Вызов методов, определенных в интерфейсе Vehicle
        car.start();
        car.stop();

        bike.start();
        bike.stop();
    }
}