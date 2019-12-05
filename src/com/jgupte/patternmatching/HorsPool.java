package com.jgupte.patternmatching;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HorsPool {

    private static int numberOfComparisons = 0;

    static int findString(String text, String pattern) {
        Map<Character, Integer> shiftTable = new HashMap<>();

        for (int i = 0; i < pattern.length() - 1; i++) {
            shiftTable.put(pattern.charAt(i), pattern.length() - 1 - i);
        }

        int m = pattern.length();
        int i = m - 1;
        while (i < text.length()) {
            int k = 0;
            while (k < m) {
                if ((pattern.charAt(m - 1 - k) == text.charAt(i - k))) {
                    numberOfComparisons++;
                    k++;
                } else {
                    numberOfComparisons++;
                    break;
                }
            }
            if (k == m) {
                return i - m + 1;
            } else {
                int shift = (shiftTable.get(text.charAt(i)) != null) ? shiftTable.get(text.charAt(i)) : pattern.length();
                i += shift;
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
