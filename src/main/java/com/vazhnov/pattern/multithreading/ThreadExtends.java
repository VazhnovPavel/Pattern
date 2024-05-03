package com.vazhnov.pattern.multithreading;

public class ThreadExtends extends Thread{

        public void run() {
            System.out.println("ThreadExtends is running");
        }

        public static void main(String[] args) {
            ThreadExtends myThread = new ThreadExtends();
            myThread.start();
        }


}
