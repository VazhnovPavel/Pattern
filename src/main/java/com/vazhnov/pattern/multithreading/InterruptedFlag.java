package com.vazhnov.pattern.multithreading;

public class InterruptedFlag extends Thread {

        public void run() {
            while (!isInterrupted()) {
                try {
                    // Работаем в цикле, пока поток не будет прерван
                    System.out.println("MyThread is running");
                    Thread.sleep(1000); // Приостанавливаем поток на 1 секунду
                } catch (InterruptedException e) {
                    // Обработка исключения, если поток был прерван
                    System.out.println("MyThread has been interrupted");
                    return; // Завершаем выполнение потока
                }
            }
        }

        public static void main(String[] args) {
            InterruptedFlag myThread = new InterruptedFlag();
            myThread.start();

            try {
                // Приостанавливаем выполнение основного потока на 3 секунды
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Прерываем выполнение потока myThread
            myThread.interrupt();
        }
    }

