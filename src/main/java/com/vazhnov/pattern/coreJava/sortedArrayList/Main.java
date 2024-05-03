package com.vazhnov.pattern.coreJava.sortedArrayList;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(2);
        list.add(8);
        list.add(1);

        System.out.println("Original list: " + list);

        Collections.sort(list);

        System.out.println("Sorted list: " + list);
    }
}

