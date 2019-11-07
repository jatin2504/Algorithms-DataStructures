package com.jgupte.sorting;

public class CountingSort {
    public static int[] sort(int[] arr, int range) {
        int[] result = new int[arr.length];
        int[] count = new int[range + 1];

        //Count occurrences
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]] = count[arr[i]] + 1;
        }

        //cumulative sum
        for (int i = 1; i < count.length; i++) {
            count[i] = count[i] + count[i - 1];
        }

        //place items at their correct index
        for (int i = arr.length - 1; i >= 0; i--) {
            int index = count[arr[i]];
            result[index - 1] = arr[i];
            count[arr[i]]--;

        }
        return result;
    }


    public static void main(String[] args) {
        int[] arr = sort(new int[]{2, 5, 1, 0, 3, 1, 0, 5}, 5);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}
