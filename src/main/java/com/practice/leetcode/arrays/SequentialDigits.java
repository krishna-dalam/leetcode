package com.practice.leetcode.arrays;

/*
    Sequential Digits

    An integer has sequential digits if and only if each digit in the number is one more than the previous digit.

    Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.

    Example 1:
    Input: low = 100, high = 300
    Output: [123,234]

    Example 2:
    Input: low = 1000, high = 13000
    Output: [1234,2345,3456,4567,5678,6789,12345]

    Constraints:
    10 <= low <= high <= 10^9

 */

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SequentialDigits {
    public static void main(String[] args) {
        int min = 1000, max = 13000;
        int minLen = len(min);
        int  maxLen = len(max);
        for(int i=minLen; i<=maxLen; i++){
            findPossibleSeqDigits(i, min , max).forEach(e -> System.out.println(e));
        }

    }

    private static List<Integer> findPossibleSeqDigits(int len, int min, int max){
        ArrayList<StringBuilder> arr = new ArrayList<>();
        int i=1;
        while(i+len-1 <= 9){
            StringBuilder str = new StringBuilder();
            for(int j=i; j<i+len; j++){
                str.append(j);
            }
            if(Integer.parseInt(str.toString()) >= min && Integer.parseInt(str.toString()) <= max)
                arr.add(str);
            i++;
        }
        return arr.stream().map(e -> Integer.valueOf(e.toString())).collect(Collectors.toList());
    }

    private static int len(int val) {
        int length = 0;
        while(val>0){
            val/=10;
            length++;
        }
        return length;
    }
}
