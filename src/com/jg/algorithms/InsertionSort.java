package com.jg.algorithms;

public class InsertionSort {
    public static void sort(int[] arr) {
        if (arr.length == 0) {
            System.out.println("The array is empty");
        } else {
            long startTime = System.currentTimeMillis();
            for (int i = 1; i < arr.length; i++) {
                for (int j = i; j > 0; j--) {
                    if (arr[j] < arr[j - 1]) {
                        int temp = arr[j];
                        arr[j] = arr[j - 1];
                        arr[j - 1] = temp;
                    } else {
                        break;
                    }
                }
            }
        }
    }
}
