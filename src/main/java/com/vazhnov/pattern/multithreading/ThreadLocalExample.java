package com.vazhnov.pattern.multithreading;

public class ThreadLocalExample {
    // Создаем объект ThreadLocal
    private static ThreadLocal<Integer> threadLocalValue = ThreadLocal.withInitial(() -> (int) Thread.currentThread().getId());

    public static void main(String[] args) {
        // Создаем и запускаем несколько потоков
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                // Получаем текущее значение переменной для данного потока
                int value = threadLocalValue.get();
                // Изменяем значение переменной для данного потока
                value++;
                // Устанавливаем новое значение переменной для данного потока
                threadLocalValue.set(value);
                // Выводим текущее значение переменной для данного потока
                System.out.println("Thread " + Thread.currentThread().getId() + ": Value + 1  = " + value);
            });
            thread.start();
        }
    }
}


