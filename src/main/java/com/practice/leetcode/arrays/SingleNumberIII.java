package com.practice.leetcode.arrays;

import java.util.stream.IntStream;

public class SingleNumberIII {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 3, 2, 5};

        int xor = nums[0];
        for(int i=1; i<nums.length; i++){
            xor ^= nums[i];
        }
        System.out.println(xor);
    }
}
