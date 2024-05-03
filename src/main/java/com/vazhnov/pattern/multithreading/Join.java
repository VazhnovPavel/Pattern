package com.vazhnov.pattern.multithreading;

public class Join {

    public static void main(String[] args) throws InterruptedException {
        Thread sleepy = new Thread(() -> {
            try {
                System.out.println("Надо бы поспать");
                Thread.sleep(5000);
                System.out.println("Доброе утро, мир!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        sleepy.start();
        System.out.println("ждём...");
        sleepy.join();
        System.out.println("закончили");
    }
}
