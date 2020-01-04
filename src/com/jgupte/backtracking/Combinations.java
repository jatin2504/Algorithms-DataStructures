package com.jgupte.backtracking;

import java.util.*;

public class Combinations {
    List<List<Integer>> combinations = new ArrayList<>();

    public void getCombinations(int[] A) {
        Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
        for (int a : A) {
            countMap.compute(a, (key, val) -> {
                if (val == null)
                    return 1;
                else
                    return val + 1;
            });
        }

        int[] count = new int[countMap.size()];
        int[] input = new int[countMap.size()];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            count[i] = entry.getValue();
            input[i] = entry.getKey();
            i++;
        }
        int[] output = new int[A.length];


        backtrack(input, count, 0, output, 0);

    }

    private void backtrack(int[] input, int[] count, int pos, int[] output, int len) {
        print(output, len);
        for (int i = pos; i < input.length; i++) {
            if (count[i] == 0)
                continue;

            output[len] = input[i];
            count[i]--;
            backtrack(input, count, i, output, len + 1);
            count[i]++;
        }
    }

    private void print(int[] output, int len) {
        for (int i = 0; i < len; i++)
            System.out.print(output[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Combinations combinations = new Combinations();
        combinations.getCombinations(new int[]{1, 2, 3});
        PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> o1 - o2);
        q.offer(3);
        q.add(6);
        q.add(2);
        q.add(7);
        q.offer(5);

        System.out.println(q.peek());
    }
}
