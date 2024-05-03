package com.vazhnov.pattern.multithreading;

public class Mutex {
    private static int counter = 0;
    private static final Object mutex = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> increment());
        Thread thread2 = new Thread(() -> increment());

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Counter Value: " + counter);
    }

    private static void increment() {
        synchronized (mutex) {
            for (int i = 0; i < 1000; i++) {
                counter++;
            }
        }
    }
}

