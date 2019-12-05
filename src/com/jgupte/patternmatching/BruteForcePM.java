package com.jgupte.patternmatching;

import java.util.Date;
import java.util.Scanner;

public class BruteForcePM {
    private static int numberOfComparisons = 0;

    static int findString(String text, String pattern) {
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == pattern.charAt(0)) {
                int j = 0;
                while (j < pattern.length() && (i + j) < text.length()) {
                    if(text.charAt(i + j) == pattern.charAt(j)) {
                        numberOfComparisons++;
                        j++;
                    } else {
                        numberOfComparisons++;
                        break;
                    }
                }

                if (j == pattern.length()) {
                    return i;
                }
            } else {
                numberOfComparisons++;
            }
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
