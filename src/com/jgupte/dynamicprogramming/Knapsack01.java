package com.jgupte.dynamicprogramming;

public class Knapsack01 {
    public static int calculateKnapsack(int[] wt, int[] val, int capacity) {
        int[][] dpMatrix = new int[wt.length + 1][capacity + 1];
        for (int i = 0; i < dpMatrix.length; i++) {
            for (int j = 0; j < dpMatrix[i].length; j++) {
                if (i == 0 || j == 0) {
                    dpMatrix[i][j] = 0;
                    continue;
                }

                if (j < wt[i - 1]) {
                    dpMatrix[i][j] = dpMatrix[i - 1][j];
                } else {
                    dpMatrix[i][j] = Math.max(dpMatrix[i - 1][j], val[i - 1] + dpMatrix[i - 1][j - wt[i - 1]]);
                }
            }
        }

        System.out.println(":::: Items Selected ::::");
        int i = wt.length;
        int j = capacity;
        while (i != 1 && j !=0) {
            if (dpMatrix[i][j] != dpMatrix[i - 1][j]) {
                System.out.println("Weight: " + wt[i - 1] + " Value: " + val[i - 1]);
                i--;
                j = j - wt[i - 1];
            } else {
                i--;
            }
        }


        return dpMatrix[wt.length][capacity];
    }

    public static void main(String[] args) {
        int[] wt = {1, 3, 4, 5};
        int[] val = {1, 4, 5, 7};
        int capacity = 7;

        System.out.println(calculateKnapsack(wt, val, capacity));
    }
}
