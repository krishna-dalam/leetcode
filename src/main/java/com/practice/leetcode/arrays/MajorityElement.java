package com.practice.leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MajorityElement {
    public static void main(String[] args) {
//        int[] nums = {1,2,3,1,2,1,1,1};
//        int[] nums = {1};

//        Arrays.stream(nums).boxed().collect(Collectors.toList());
//        int n = nums.length;
//        int maxEle = Math.floorDiv(n, 3);
//        ArrayList<Integer> res = new ArrayList<>();
//        for(int i=0; i<maxEle; i++){
//            int maj =  majority(nums, maxEle);
//            if( maj != Integer.MAX_VALUE)
//                res.add(maj);
//        }
//
//        res.forEach(e -> System.out.println(e));

        print(32);

    }

    private static void print(int n){
        if(n>1){
            print(n/2);
            print(n/2);
            for(int i=1; i<n; i++){
                System.out.println("print");
            }
        }
    }

    private static int majority(int[] nums, int freq){
        int count = 1;
        int ele = Integer.MAX_VALUE;

        for (int num : nums) {
            if(num != Integer.MAX_VALUE){
                if (num == ele)
                    count++;
                else {
                    count--;
                    if (count == 0) {
                        count = 1;
                        ele = num;
                    }
                }
            }

        }

        if(findCount(nums, ele) > freq){
            mark(nums, nums.length, ele);
            return ele;
        }else {
            return Integer.MAX_VALUE;
        }
    }

    private static void mark(int[] nums,int n, int ele) {
        for(int i=0; i<n; i++){
            if(nums[i] == ele)
                nums[i] = Integer.MAX_VALUE;
        }
    }

    private static int findCount(int[] arr, int ele){
        return (int) Arrays.stream(arr).filter(e -> e == ele).count();
    }


}
