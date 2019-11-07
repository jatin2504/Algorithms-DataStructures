package com.jgupte.programs;

public class MatrixMultiplication {
    public static void main(String args[]) {
        int[][] A = {{1, 2, 3}, {7, 5, 1}};
        int[][] B = {{8, 2}, {7, 1}, {5, 3}};
        int[][] C = new int[A.length][B[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B[i].length; j++) {
                int sum = 0;
                for (int k = 0; k < A[i].length; k++) {
                    sum += A[i][k] * B[k][j];
                }
                C[i][j] = sum;
            }
        }

        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < C[i].length; j++) {
                System.out.print(C[i][j] + " ");
            }
            System.out.println();
        }
    }
}
