package com.practice.leetcode.arrays;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;


/*
    Digit Pairs

    Given N three digit numbers, your task is to find bit scores of all N numbers and then print the number of pairs possible
    based on these calculated bit score

    1. Rule to calculate bit score
       - extract largest digit and multiply by 11
       - extract smallest digit and multiply by 7
       - add these two values
     Note: Bit score should be of 2 digits. If the sum results in 3 digits then ignore the most significant value
     Ex: 286 -> 8*11 + 2*7 = 102 -> bit score = 02
         123 -> 3*11 + 1*7 = 40  -> bit score = 40
    2. Rule from making pairs from above calculated bit scores
       - Both bit scores should be in either odd position or even position to qualify for pair
       - Pairs are only made if most significant digit is same and at most 2 pair can be made for a given significant digit


    Example:
        Input:
        8
        234 567 321 345 123 110 767 111

        Output:
        3
      Explanation:
        Bit scores : 58 12 40 76 40 11 19 18

        No of possible pairs = 3

        40 appears at odd indices 3 & 5 -> one pair

        12, 11, 18 appears at even indices 2, 6 & 8 -> 2 pairs

 */

public class DigitPairs {
    public static void main(String[] args) {
        int n = 8;
        int[] input = {234, 567, 321, 345, 123, 110, 767, 111};

        int[] bitScores = new int[n];

        AtomicInteger ai = new AtomicInteger(0);
        Arrays.stream(input).forEach(i -> bitScores[ai.getAndAdd(1)] = getBitScore(i));

        AtomicInteger count = new AtomicInteger();
        int i= ai.decrementAndGet();
        Map<Integer, Integer> evenMap = new HashMap<>();
        Map<Integer, Integer> oddMap = new HashMap<>();

        while(i>=0){
            if(i%2 == 0){
                evenMap.put(bitScores[i]/10, evenMap.getOrDefault(bitScores[i]/10, 0) + 1);
            }else {
                 oddMap.put(bitScores[i]/10,  oddMap.getOrDefault(bitScores[i]/10, 0) + 1);
            }
            i--;
        }
        evenMap.keySet().forEach(e-> increment(evenMap, e, count));

        oddMap.keySet().forEach(o-> increment(oddMap, o, count));

        System.out.println(count);
    }

    private static void increment(Map<Integer, Integer> map, Integer i, AtomicInteger count){
        int freq = map.getOrDefault(i, 0);
        if(freq > 2){
            count.addAndGet(2);
        }else if(freq == 2){
            count.getAndIncrement();
        }
    }

    private static int getBitScore(int i) {
        int a = i/100;
        int b = i/10 - 10*a;
        int c = i - 100*a - 10*b;
        int sum = getMax(a, b, c) * 11 + getMin(a, b, c) * 7;
        return sum < 100 ? sum : sum - ((sum/100) * 100);
    }
    private static int getMax(int a, int b, int c){
        return a >= b && a >= c ? a : Math.max(b, c);
    }

    private static int getMin(int a, int b, int c){
        return a <= b && a <= c ? a : Math.min(b, c);
    }
}
