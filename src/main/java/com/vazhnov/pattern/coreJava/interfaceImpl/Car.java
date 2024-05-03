package com.vazhnov.pattern.coreJava.interfaceImpl;

// Класс, который реализует интерфейс Vehicle
class Car implements Vehicle {
    @Override
    public void start() {
        System.out.println("Car started");
    }

    @Override
    public void stop() {
        System.out.println("Car stopped");
    }
}