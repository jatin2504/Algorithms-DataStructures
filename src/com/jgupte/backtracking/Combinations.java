package com.jgupte.backtracking;

import java.util.*;

public class Combinations {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        subsetsUtil(nums, subset, result, 0);
        return result;
    }

    private void subsetsUtil(int[] nums, List<Integer> subset, List<List<Integer>> result, int index) {
        result.add(new ArrayList<>(subset));
        for (int i = index; i < nums.length; i++){
            subset.add(nums[i]);
            subsetsUtil(nums, subset, result, i+1);
            subset.remove(subset.size() - 1);
        }
    }


    private void print(int[] output, int len) {
        for (int i = 0; i < len; i++)
            System.out.print(output[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Combinations combinations = new Combinations();
        System.out.println(combinations.subsets(new int[]{1, 2, 3}));
    }
}
