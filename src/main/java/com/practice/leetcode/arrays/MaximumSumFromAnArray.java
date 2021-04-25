package com.practice.leetcode.arrays;

/*
    Given K and an array of integers

    Find maximum number of elements can be picked from the array such that these are neighbours

    Ex:  5 {1, 3, 2, 2, 1}
    Ans: 3 : {2, 2, 1}
 */

import java.util.LinkedList;
import java.util.Queue;

public class MaximumSumFromAnArray {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 2, 1};
        int k = 5;

        Queue<Integer> queue = new LinkedList<>();
        int max = 0;
        int sum = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i]<=k){
                queue.add(arr[i]);
            }
        }
    }
}
