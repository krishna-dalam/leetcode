package com.practice.leetcode.arrays;

import java.util.HashMap;
import java.util.Map;

/*
    Top K Frequent Elements

    Given a non-empty array of integers, return the k most frequent elements.

    Example 1:
    Input: nums = [1,1,1,2,2,3], k = 2
    Output: [1,2]

    Example 2:
    Input: nums = [1], k = 1
    Output: [1]

    Note:
     - You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
     - Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
     - It's guaranteed that the answer is unique, in other words the set of the top k frequent elements is unique.
     - You can return the answer in any order.
 */
public class TopKFrequentElements {
    public static void main(String[] args) {
        int[] input = {4,5,5,2,1,1,1,5,2,3,3,5,2};
        int k = 3;

        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int i: input) {
            frequencyMap.merge(i, 1, Integer::sum);
        }

        int[] res = new int[k];

        for(int i=0; i<k; i++){
            res[i] = findLargestFreqNumber(frequencyMap);
        }

        for(int i: res){
            System.out.println(i);
        }
    }

    private static int findLargestFreqNumber(Map<Integer, Integer> map){
        int number = 0;
        int largest = 0;
        for (Integer m: map.keySet()) {
            int freq = map.get(m);
            if(freq>largest){
                largest = freq;
                number = m;
            }
        }
        map.put(number, -1);
        return number;
    }
}
