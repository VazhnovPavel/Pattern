package com.vazhnov.pattern.coreJava.addHashSet;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();

        // Добавление значений в HashSet
        set.add("apple");
        set.add("banana");
        set.add("orange");
        set.add("apple"); // HashSet не допускает дубликаты

        // Вывод HashSet
        System.out.println("HashSet: " + set);
    }
}

