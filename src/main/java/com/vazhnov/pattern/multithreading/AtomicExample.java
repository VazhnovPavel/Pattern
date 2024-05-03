package com.vazhnov.pattern.multithreading;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicExample {
    public static void main(String[] args) {
        AtomicLong atomicLong = new AtomicLong(10);
        long newValue = 20;
        long oldValue = 10;
        boolean compareResult = atomicLong.compareAndSet(oldValue, newValue);

        if (compareResult) {
            System.out.println("Value updated successfully. New value: " + atomicLong.get());
        } else {
            System.out.println("Value update failed.");
        }
    }
}