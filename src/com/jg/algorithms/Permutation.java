package com.jg.algorithms;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    static int sIndex;
    static int eIndex;

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();

        return permutations;

    }

    public void permute(List<List<Integer>> permutations, int[] nums, int sIndex, int eIndex) {
        if (eIndex - sIndex == 1) {
            int temp = nums[sIndex];
            nums[sIndex] = nums[eIndex];
            nums[eIndex] = temp;
        }



    }
}
