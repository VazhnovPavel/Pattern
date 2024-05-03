package com.vazhnov.pattern.coreJava.reverseText;

public class Main {
    public static void main(String[] args) {
        String str = "Hello, World!";
        StringBuilder reversedStr = new StringBuilder(str).reverse();
        System.out.println("Original string: " + str);
        System.out.println("Reversed string: " + reversedStr);
    }
}
