package com.vazhnov.pattern.multithreading;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Этот код демонстрирует использование метода getAndIncrement класса AtomicInteger для атомарного увеличения
 * значения переменной на 1 и получения нового значения.
 */

    public class AtomicIncrement {
        public static void main(String[] args) {
                AtomicInteger atomicInteger = new AtomicInteger(10);
                int newValue = atomicInteger.getAndIncrement();

                System.out.println("New value: " + newValue);
        }
    }

