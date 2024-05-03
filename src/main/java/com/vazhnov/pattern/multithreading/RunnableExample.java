package com.vazhnov.pattern.multithreading;

public class RunnableExample implements Runnable {

        public void run() {
            System.out.println("MyRunnable is running");
        }
        public static void main(String[] args) {
            RunnableExample myRunnable = new RunnableExample();
            Thread thread = new Thread(myRunnable);
            thread.start();
        }
    }
