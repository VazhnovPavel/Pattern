package com.vazhnov.pattern.coreJava.interfaceImpl;
// Класс, который также реализует интерфейс Vehicle
class Bike implements Vehicle {
    @Override
    public void start() {
        System.out.println("Bike started");
    }

    @Override
    public void stop() {
        System.out.println("Bike stopped");
    }
}