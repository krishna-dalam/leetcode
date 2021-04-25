package com.practice.leetcode.arrays;

import java.util.Arrays;
import java.util.TreeMap;
import java.util.TreeSet;

/*
    Sliding Window Maximum

    Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.

    Follow up:
    Could you solve it in linear time?

    Example:

    Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
    Output: [3,3,5,5,6,7]
    Explanation:

    Window position                Max
    ---------------               -----
    [1  3  -1] -3  5  3  6  7       3
     1 [3  -1  -3] 5  3  6  7       3
     1  3 [-1  -3  5] 3  6  7       5
     1  3  -1 [-3  5  3] 6  7       5
     1  3  -1  -3 [5  3  6] 7       6
     1  3  -1  -3  5 [3  6  7]      7


 */
public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        Arrays.stream(slidingWindowMaximum(arr, k)).forEach(i -> System.out.println(i));
    }

    private static int[] slidingWindowMaximum(int[] arr, int k) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int len = arr.length;
        int[] res = new int[len-k+1];
        for(int i=0; i<k; i++){
            treeMap.put(arr[i], treeMap.getOrDefault(arr[i], 0) + 1);
        }
        int l = 0;
        res[l++] = treeMap.lastKey();

        for(int i=k; i<len; i++){
            int count = treeMap.get(arr[i-k]) - 1;
            if(count == 0){
                treeMap.remove(arr[i-k]);
            }else {
                treeMap.put(arr[i-k], count);
            }


            treeMap.put(arr[i], treeMap.getOrDefault(arr[i], 0) + 1);
            res[l++] = treeMap.lastKey();
        }
        return res;
    }
}
