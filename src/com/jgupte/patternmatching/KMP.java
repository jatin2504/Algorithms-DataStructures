package com.jgupte.patternmatching;

import java.util.Scanner;

public class KMP {
    private static int numberOfComparisons = 0;

    private static int[] computeFailureFunction(String pattern) {
        int[] failureFunctionArr = new int[pattern.length()];
        int index = 0;
        for (int i = 1; i < pattern.length(); ) {
            if (pattern.charAt(i) == pattern.charAt(index)) {
                failureFunctionArr[i] = index + 1;
                index++;
                i++;
            } else {
                if (index != 0) {
                    index = failureFunctionArr[index - 1];
                } else {
                    failureFunctionArr[i] = 0;
                    i++;
                }
            }
        }
        return failureFunctionArr;
    }

    public static int findString(String text, String pattern) {

        int lps[] = computeFailureFunction(pattern);
        int i = 0;
        int j = 0;
        while (i < text.length() && j < pattern.length()) {
            if (text.charAt(i) == pattern.charAt(j)) {
                numberOfComparisons++;
                i++;
                j++;
            } else {
                numberOfComparisons++;
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        if (j == pattern.length()) {
            return i - j;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("::: Enter Text :::");
        String text = in.nextLine();
        System.out.println("::: Enter Pattern :::");
        String pattern = in.nextLine();
        findString(text, pattern);
        System.out.println("Number of comparisons: " + numberOfComparisons);
    }
}
