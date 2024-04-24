package com.vazhnov.pattern.sorting;

public class myBinarySearch {
    public static void main(String[] args) {
        var sortedArray = new int[5000];
        for (int i = 0; i < sortedArray.length ; i++) {
            sortedArray[i] = i * 10;
        }
        System.out.println(binaryIndexOf(sortedArray,2500));
    }

    private static int binaryIndexOf(int[] sortedArray,int element ){
        var left = 0;
        var right = sortedArray.length-1;
        int count = 0;
        while (left <= right){
            count++;
            var middle = (left + right) / 2;
            var current = sortedArray[middle];
            if (current == element) {
                System.out.println("Итераций: " + count);
                return current;
            }
            else if (current < element) {
                left = middle + 1;
            } else if (current > element) {
                right = middle -1;
            }
        }
        System.out.println("Итераций: " + count);
        return -1;
    }
}
