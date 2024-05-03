package com.vazhnov.pattern.coreJava.addMassiv;
public class Main {
    public static void main(String[] args) {
        // Создание двумерного массива размером 3x3
        int[][] matrix = new int[3][3];

        // Добавление значений в двумерный массив
        matrix[0][0] = 1;
        matrix[0][1] = 2;
        matrix[0][2] = 3;
        matrix[1][0] = 4;
        matrix[1][1] = 5;
        matrix[1][2] = 6;
        matrix[2][0] = 7;
        matrix[2][1] = 8;
        matrix[2][2] = 9;

        // Вывод двумерного массива
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
