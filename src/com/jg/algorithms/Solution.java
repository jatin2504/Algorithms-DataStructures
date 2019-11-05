package com.jg.algorithms;

public class Solution {

    public static void main(String[] args) {
        int arr[] = {};
        int a = 0, i = 0, k = -1, t = 0;

        while (i < arr.length) {
            if (arr[i] == 0) {
                if (arr[a] != 0) {
                    if (k == -1 && i != 0) {
                        k = i - 1;
                        t = arr[k];
                    }
                    if (k >= a) {
                        if (k == a) {
                            arr[k] = 0;
                            arr[i] = t;
                            k = -1;
                            a++;
                        } else {
                            arr[k] = arr[k - 1];
                            k--;
                        }
                    }
                }
                else{
                    i++;
                    a++;
                }
            } else {
                i++;

            }
        }
        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j] + " ");
        }

    }
}
