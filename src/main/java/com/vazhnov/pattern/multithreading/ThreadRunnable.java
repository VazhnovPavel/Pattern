package com.vazhnov.pattern.multithreading;

public class ThreadRunnable implements Runnable{

        public void run() {
            System.out.println("ThreadRunnable is running");
        }

        public static void main(String[] args) {
            ThreadRunnable myRunnable = new ThreadRunnable();
            Thread thread = new Thread(myRunnable);

            thread.start();
        }


}
