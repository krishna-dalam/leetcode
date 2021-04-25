package com.practice.leetcode.strings;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {

    public static void main(String[] args) {
        int[] nums = {3, 30, 34, 5, 9};
        System.out.println(largestNumber(nums));
    }

    private static String largestNumber(int[] nums) {

        // 3, 30, 34, 5, 9

        // 330, 343, 53, 93


        int len = nums.length;
        String[] arr = new String[len];
        for(int i=0; i<len; i++){
            arr[i]=String.valueOf(nums[i]);
        }

        Arrays.sort(arr, (a, b) -> (b+a).compareTo(a+b));

        StringBuilder sb = new StringBuilder();
        for(String s: arr)
            sb.append(s);

        while(sb.charAt(0)=='0' && sb.length()>1)
            sb.deleteCharAt(0);

        return sb.toString();
    }
}
