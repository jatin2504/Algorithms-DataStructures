package com.jgupte.dynamicprogramming;


import java.util.LinkedList;

/**
 * Program to find the length of longest palindromic subsequence in a String
 * Eg.
 * Input: adfbuhubdk
 * Output : 7 (Which is length of longest palindromic subsequence "dbuhubd")
 */
public class LongestPalindromeSubSeq {

    public static int longestPalindromeSubseq(String s) {
        char[] strArr = s.toCharArray();
        int n = strArr.length;
        int[][] dp = new int[n][n];
        int i = 0;
        int j = 0;

        while (true) {
            if (i == 0 && j == n)
                break;
            while (j < n) {
                if (i == j) {
                    dp[i][j] = 1;
                } else {
                    if (strArr[i] == strArr[j]) {
                        dp[i][j] = 2 + dp[i + 1][j - 1];
                    } else {
                        dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                    }
                }
                i++;
                j++;
            }
            j = n - i + 1;
            i = 0;
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        System.out.println("Length of longest palindromic subseq is:" + longestPalindromeSubseq("adfbuhubdk"));
    }
}
