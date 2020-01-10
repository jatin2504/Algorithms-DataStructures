package com.jgupte.dynamicprogramming;

/**
 * Program to find longest palindromic substring in a String
 * Eg.
 * Input: abachdhca
 * Output : achdhca
 */
public class LongestPalindromicStr {
    static String getLongestPalindromicStr(String str) {
        int n = str.length();

        if (str == null || n < 2) {
            return str;
        }

        boolean[][] dp = new boolean[n][n];
        int start = 0;
        int end = 0;

        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                boolean innerPalindrome = dp[i + 1][j - 1] || j - i <= 2;

                if (str.charAt(i) == str.charAt(j) && innerPalindrome) {
                    dp[i][j] = true;
                    if (end - start < j - i) {
                        start = i;
                        end = j;
                    }
                }
            }
        }

        return str.substring(start, end + 1);
    }

    public static void main(String[] args){
        System.out.println(getLongestPalindromicStr("abacddca"));
    }
}
