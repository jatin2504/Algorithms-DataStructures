package com.jgupte.sorting;

public class HeapSort {
    public static void sort(int[] arr) {

        int[] heap = new int[arr.length + 1];
        int n = 1;
        while (n < heap.length) {
            int i = n;
            heap[i] = arr[i - 1];
            while (i > 1 && heap[i / 2] > heap[i]) {
                int temp = heap[i / 2];
                heap[i / 2] = heap[i];
                heap[i] = temp;
                i = i / 2;
            }
            n = n + 1;
        }
        while (n > 1) {
            arr[heap.length - n] = heap[1];
            heap[1] = heap[n - 1];
            n = n - 1;

            int i = 1;
            while (i < n) {
                if ((2 * i + 1) <= n) {
                    if ((heap[i] <= heap[2 * i]) && (heap[i] <= heap[2 * i + 1])) {
                        break;
                    } else {
                        if (heap[2 * i] < heap[2 * i + 1]) {
                            int temp = heap[2 * i];
                            heap[2 * i] = heap[i];
                            heap[i] = temp;
                            i = 2 * i;
                        } else {
                            int temp = heap[2 * i + 1];
                            heap[2 * i + 1] = heap[i];
                            heap[i] = temp;
                            i = 2 * i + 1;
                        }
                    }
                } else {
                    if ((2 * i <= n) && (heap[2 * i] < heap[i])) {
                        int temp = heap[2 * i];
                        heap[2 * i] = heap[i];
                        heap[i] = temp;
                        i = 2 * i;
                    }
                    i++;
                }
            }
        }
    }

}
