package com.vazhnov.pattern.multithreading;

import java.util.concurrent.CountDownLatch;

/**
 * В этом примере создаётся CountDownLatch с количеством событий, равным количеству задач.
 * Затем запускается NUM_TASKS потоков, каждый из которых выполняет некоторую задачу и уменьшает счётчик
 * после её завершения. Основной поток блокируется до тех пор, пока счётчик не достигнет нуля, после чего выводит
 * сообщение о том, что все задачи завершены.
 */

public class CountDownLatchExample {
    private static final int NUM_TASKS = 5;
    private static CountDownLatch latch = new CountDownLatch(NUM_TASKS);

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < NUM_TASKS; i++) {
            new Thread(() -> {
                // Выполняем задачу
                latch.countDown();
            }).start();
        }

        latch.await(); // Блокируем основной поток до завершения всех задач
        System.out.println("Все задачи завершены");
    }
}
