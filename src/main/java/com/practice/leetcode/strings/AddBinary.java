package com.practice.leetcode.strings;

/*
    Add Binary

    Given two binary strings, return their sum (also a binary string).
    The input strings are both non-empty and contains only characters 1 or 0.

    Example 1:
    Input: a = "11", b = "1"
    Output: "100"

    Example 2:
    Input: a = "1010", b = "1011"
    Output: "10101"

    Constraints:
     - Each string consists only of '0' or '1' characters.
     - 1 <= a.length, b.length <= 10^4
     - Each string is either "0" or doesn't contain any leading zero.
 */

import java.util.Stack;

public class AddBinary {
    public static void main(String[] args) {
        String a = "100", b = "100";

        Stack<Integer> stack = new Stack<>();


        int aLen = a.length();
        int bLen = b.length();

        int temp = 0;
        while(aLen>0 || bLen>0){
            int sum = (aLen > 0 ? Integer.parseInt(a.charAt(aLen - 1) + "") : 0) + (bLen > 0 ? Integer.parseInt(b.charAt(bLen - 1) + "") : 0) + temp;
            switch (sum){
                case 1:
                    stack.push(1);
                    temp = 0;
                    break;
                case 2:
                    stack.push(0);
                    temp = 1;
                    break;
                case 3:
                    stack.push(1);
                    temp = 1;
                    break;
                default:
                    stack.push(0);
            }
            aLen--;
            bLen--;
        }

        if(temp == 1){
            stack.push(1);
        }
        String res = "";
        while (!stack.isEmpty()){
            res = res.concat(String.valueOf(stack.pop()));
        }
        System.out.println(res);

    }
}
