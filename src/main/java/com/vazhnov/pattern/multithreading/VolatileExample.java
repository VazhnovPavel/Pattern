package com.vazhnov.pattern.multithreading;
/**
 * В этом примере stop является volatile переменной, которая используется для остановки рабочего потока.
        Поскольку stop объявлен как volatile, изменения в его значении будут видны всем потокам без использования
        дополнительных механизмов синхронизации.
        */

public class VolatileExample {
    private static volatile boolean stop = false;

    public static void main(String[] args) {
        new Thread(() -> {
            while (!stop) {
                System.out.println("Working...");
            }
        }).start();

        try {
            Thread.sleep(1000); // Даем потоку немного поработать
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        stop = true; // Устанавливаем volatile переменную в true, чтобы остановить поток
    }
}