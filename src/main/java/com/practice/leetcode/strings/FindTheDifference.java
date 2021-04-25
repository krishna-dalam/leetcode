package com.practice.leetcode.strings;

/*
    Find the Difference
    Given two strings s and t which consist of only lowercase letters.

    String t is generated by random shuffling string s and then add one more letter at a random position.

    Find the letter that was added in t.

    Example:

    Input:
    s = "abcd"
    t = "abcde"

    Output:
    e

    Explanation:
    'e' is the letter that was added.
 */

import java.util.HashMap;
import java.util.Map;

public class FindTheDifference {
    public static void main(String[] args) {
        String s = "abcd";
        String t = "eabcd";

        System.out.println(findTheDifference(s, t));

    }

    private static char findTheDifference(String s, String t) {
        // aaaaa

        Map<Character, Integer> charCount = new HashMap<>();
        for(char c: t.toCharArray())
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);

        for(char c: s.toCharArray()){
            int count = charCount.getOrDefault(c, 0);
            if(count != 0){
                charCount.put(c, --count);
            }
            if(count == 0){
                charCount.remove(c);
            }
        }
        return charCount.keySet().stream().findFirst().get();
    }

//    private static char findTheDifference(String s, String t) {
//        int count = 0;
//        for(char c: t.toCharArray()){
//            count += c - 97;
//        }
//
//        for(char c: s.toCharArray()){
//            count-= c - 97;
//        }
//
//        return (char)(count+97);
//    }
}