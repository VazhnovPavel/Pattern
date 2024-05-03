package com.vazhnov.pattern.multithreading;

public class DaemonThreadExample {
        public static void main(String[] args) {
            Thread daemonThread = new Thread(() -> {
                while (true) {
                    try {
                        System.out.println("Daemon thread is running");
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

            // Устанавливаем поток как демонический
            daemonThread.setDaemon(true);

            // Запускаем поток
            daemonThread.start();

            // Главный поток
            System.out.println("Main thread is finished");
        }
    }

