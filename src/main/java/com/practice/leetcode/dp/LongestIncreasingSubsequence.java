package com.practice.leetcode.dp;

/*
    Longest Increasing Subsequence

    The Longest Increasing Subsequence (LIS) problem is to find the length of the longest subsequence of a given
    sequence such that all elements of the subsequence are sorted in increasing order. For example, the length of
    LIS for {10, 22, 9, 33, 21, 50, 41, 60, 80} is 6 and LIS is {10, 22, 33, 50, 60, 80}.

    Examples
    Input: arr[] = {3, 10, 2, 1, 20}
    Output: Length of LIS = 3
    The longest increasing subsequence is 3, 10, 20

    Input: arr[] = {3, 2}
    Output: Length of LIS = 1
    The longest increasing subsequences are {3} and {2}

    Input: arr[] = {50, 3, 10, 7, 40, 80}
    Output: Length of LIS = 4
    The longest increasing subsequence is {3, 7, 40, 80}
 */

import java.util.PriorityQueue;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int[] arr = {10, 22, 9, 33, 21, 50, 41, 60};
//        int[] arr = {3, 10, 2, 1, 20};

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(3);
        priorityQueue.add(2);
        priorityQueue.add(1);

        priorityQueue.forEach(e -> System.out.println(e));
//        System.out.println(longestIncreasingSubsequence(arr));

    }

    private static int longestIncreasingSubsequence(int[] arr){
        int len = arr.length;

        int[] lis = new int[len];

        for(int i=0; i<len; i++)
            lis[i] = 1;

        for(int i=1; i<len; i++){
            for(int j=0; j<i; j++)
                if(arr[i] > arr[j])
                    lis[i] = Math.max(lis[i], lis[j] + 1);
        }
        int max= 0;
        for(int i=0; i<len; i++){
            if(lis[i] > max)
                max = lis[i];
        }

        return max;


    }
}
