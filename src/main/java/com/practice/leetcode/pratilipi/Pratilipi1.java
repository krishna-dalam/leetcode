package com.practice.leetcode.pratilipi;

import java.util.HashSet;
import java.util.Set;

public class Pratilipi1 {
    public static void main(String[] args) {
        int[] arr = {25, 10, 2, 8, 5, 3};
//        System.out.println(findMaximumXOR(arr));

        int x = -4;
        System.out.println(x>>1);
        int y = 4;
        System.out.println(y>>1);

    }

    public static int findMaximumXOR(int[] nums) {
        int mask = 0, max = 0;
        for(int i = 31; i >= 0; i--) {
            mask = mask | (1 << i);
            Set<Integer> set = new HashSet();
            for(int num : nums)
                set.add(mask & num);

            int tmp = max | (1 << i);
            for(int prefix : set) {
                if(set.contains(tmp ^ prefix)) {
                    max = tmp;
                    break;
                }
            }
        }

        return max;
    }
}
