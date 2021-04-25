package com.practice.leetcode.strings;

import com.fasterxml.jackson.databind.util.ISO8601Utils;

import java.util.*;

public class LongestSubstringWithoutRepeatedChar {
    public static void main(String[] args) {
        String s = "dvdf";

        Map<Character, Integer> charCounts = new HashMap<>();

        List<Integer> lengths = new ArrayList<>();
        int len = 0;
        for(char c: s.toCharArray()){
            int count = charCounts.getOrDefault(c, 0);
            if(count == 0){
                len++;
            }else {
                charCounts = new HashMap<>();
                lengths.add(len);
                len = 1;
            }
            charCounts.put(c, 1);
        }
        lengths.add(len);
        lengths.sort(Comparator.reverseOrder());
        if(lengths.size()>0)
            System.out.println(lengths.get(0));
        else
            System.out.println(1);
    }
}
