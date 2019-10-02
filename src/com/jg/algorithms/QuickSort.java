package com.jg.algorithms;

public class QuickSort {

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int partIndex = getPartition(arr, startIndex, endIndex);
            quickSort(arr, startIndex, partIndex - 1);
            quickSort(arr, partIndex + 1, endIndex);
        }
    }

    private static int getPartition(int[] arr, int startIndex, int endIndex) {
        //Select middle element of array as pivot an swap it with last index
        int mid = (startIndex + endIndex) / 2;
        int temp = arr[endIndex];
        arr[endIndex] = arr[mid];
        arr[mid] = temp;

        int pivot = arr[endIndex];
        int partIndex = startIndex;
        for (int i = startIndex; i < endIndex; i++) {
            if (arr[i] <= pivot) {
                temp = arr[i];
                arr[i] = arr[partIndex];
                arr[partIndex] = temp;
                partIndex++;
            }
        }
        temp = arr[endIndex];
        arr[endIndex] = arr[partIndex];
        arr[partIndex] = temp;
        return partIndex;
    }
}
