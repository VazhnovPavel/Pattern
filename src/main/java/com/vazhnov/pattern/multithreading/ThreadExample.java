package com.vazhnov.pattern.multithreading;

public class ThreadExample extends Thread {

        public void run() {
            System.out.println("ThreadExtends is running");
        }

        public static void main(String[] args) {
            ThreadExample myThreadExample = new ThreadExample();
            myThreadExample.start();
        }


}
