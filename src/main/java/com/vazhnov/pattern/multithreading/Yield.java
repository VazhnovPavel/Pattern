package com.vazhnov.pattern.multithreading;


public class Yield {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread 1: " + i);
                // Временно уступаем выполнение другим потокам
                Thread.yield();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread 2: " + i);
                // Временно уступаем выполнение другим потокам
                Thread.yield();
            }
        });

        thread1.start();
        thread2.start();
    }
}

