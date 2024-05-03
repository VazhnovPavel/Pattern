package com.vazhnov.pattern.coreJava.myCustomTask;

public class Hyundai extends LightCar implements TestDrive,StartEngine{


    public Hyundai (int year, String model){
        this.year = year;
        this.model = model;
    }


    @Override
    public boolean goTest(boolean check) {
        if (check)
        System.out.println("Test drive success!");
        else
            System.out.println("Test drive error!");
        return check;
    }

    @Override
    public boolean testStartEngine(boolean check) {
        if (check)
        System.out.println("Hyundai start engine success!");
        else
            System.out.println("Hyundai start engine error!");
        return check;
    }
}
