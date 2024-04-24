package com.vazhnov.pattern.sorting;

class BinarySearch{
     public static void main(String[] args) {
         var sortedArray = new int[1_000_000];
         for (var i =0; i< 1_000_000; i++){
             //заполняем массив элементами (индекс * 10)
            sortedArray[i]= i*10;
         }

         var index = binaryIndexOf(sortedArray,40000);
         System.out.println(index);
     }

     public static int binaryIndexOf(int[] sortedArray, int element){

         var left = 0;
         var right = sortedArray.length-1;

         while (left <= right){
             var middle = (left + right) / 2;
             var current = sortedArray[middle];

             if (current == element)
                return middle;
             else if (current < element){
                left = middle + 1;
             }
             else if (current > element){
                 right = middle -1;
             }
         }
         return -1;
     }
}