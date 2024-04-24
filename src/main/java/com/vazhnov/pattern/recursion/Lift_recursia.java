package com.vazhnov.pattern.recursion;

import java.util.Scanner;

public class Lift_recursia {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество лифтов");
        int liftAmount = scanner.nextInt();
        System.out.println("Введите, на каких этажах останавливается каждый лифт");

        int[][] liftArray = new int[liftAmount][2];
        for (int i = 0; i < liftAmount; i++) {
            int key = scanner.nextInt();
            int value = scanner.nextInt();
            liftArray[i][0] = key;
            liftArray[i][1] = value;
        }
        int count = 0;
        recursiveMethod(liftArray,count);

        System.out.println("Максимальное количество лифтов, которые могут ездить без остановок: " + count);
    }

    public static void recursiveMethod(int[][] liftArray, int count) {
        int[][] copyLiftArray = liftArray.clone();
        int countCopy = count;

        for (int i = 0; i < copyLiftArray.length - 1; i++) {
            int[] currentLine = copyLiftArray[i];
            int[] nextLine = copyLiftArray[i + 1];

            if (currentLine != null && nextLine != null && currentLine[0] == nextLine[1]) {
                copyLiftArray[i] = null;
                countCopy++;
                recursiveMethod(copyLiftArray, countCopy);
                copyLiftArray[i] = liftArray[i];
            }
        }

        if (countCopy > count) {
            count = countCopy;
        }

        System.out.println(count);
    }

}



