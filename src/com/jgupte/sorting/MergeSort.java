package com.jgupte.sorting;

import java.util.Arrays;

public class MergeSort {
    public static int[] sort(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }
        int[] p1 = sort(Arrays.copyOfRange(arr, 0, (arr.length + 1) / 2));
        int[] p2 = sort(Arrays.copyOfRange(arr, (arr.length + 1) / 2, arr.length));
        int[] result = mergeArrays(p1, p2);
        return result;
    }

    private static int[] mergeArrays(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        int arr1Index = 0;
        int arr2Index = 0;
        for (int i = 0; i < result.length; i++) {
            if (arr1Index < arr1.length && arr2Index < arr2.length) {
                if (arr1[arr1Index] < arr2[arr2Index]) {
                    result[i] = arr1[arr1Index];
                    arr1Index++;
                } else {
                    result[i] = arr2[arr2Index];
                    arr2Index++;
                }
            } else if (arr1Index < arr1.length) {
                result[i] = arr1[arr1Index];
                arr1Index++;
            } else if (arr2Index < arr2.length) {
                result[i] = arr2[arr2Index];
                arr2Index++;
            }
        }
        return result;
    }
}
