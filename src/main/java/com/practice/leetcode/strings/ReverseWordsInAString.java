package com.practice.leetcode.strings;

/*
       Given an input string, reverse the string word by word.

       Example 1:
       Input: "the sky is blue"
       Output: "blue is sky the"

       Example 2:
       Input: "  hello world!  "
       Output: "world! hello"

       Example 3:
       Input: "a good   example"
       Output: "example good a"
       Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 */

public class ReverseWordsInAString {
    public static void main(String[] args) {
        // Result string
        String result= "";

        // Sample input string
        String input = " word1     word2     word3    word4 word5 word6      ";

        // Split the input to get each word as a string in arrOfStrings
        // split() method takes regex as input
        String[] arrOfStrings = input.split("[ ]+");

        int len = arrOfStrings.length;

        // Result string will be concatenation of strings in reverse order and concat with a space
        for (int i=0; i<len; i++)
            result = result.concat(arrOfStrings[len-i-1]).concat(" ");

        // trim() on result to remove trailing space
        System.out.print(result.trim());
    }
}
