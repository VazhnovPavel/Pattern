package com.vazhnov.pattern.coreJava.myCustomTask;

import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        Hyundai solaris = new Hyundai(2014,"Solaris");
        System.out.println("Checking system...");
        Thread.sleep(2000);
        if ((solaris.testStartEngine(random.nextBoolean()) & (solaris.goTest(random.nextBoolean()))))
        System.out.println("Diagnostick success!");
        else
        System.out.println("Diagnostick failed!");

    }
}
