package com.vazhnov.pattern.coreJava.interfaceImpl;

// Определение интерфейса
interface Vehicle {
    default void start(){
        System.out.println("default method");
    }
    void stop();
}
