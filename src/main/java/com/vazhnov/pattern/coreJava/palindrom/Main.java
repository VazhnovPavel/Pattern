package com.vazhnov.pattern.coreJava.palindrom;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(x));
    }
}