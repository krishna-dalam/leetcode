package com.practice.leetcode.math;

/*
    Implement pow(x, n), which calculates x raised to the power n (xn).

    Example 1:
    Input: 2.00000, 10
    Output: 1024.00000

    Example 2:
    Input: 2.10000, 3
    Output: 9.26100

    Example 3:
    Input: 2.00000, -2
    Output: 0.25000
    Explanation: 2-2 = 1/22 = 1/4 = 0.25

    Note:
        -100.0 < x < 100.0
        n is a 32-bit signed integer, within the range [−231, 231 − 1]
 */

public class Power {
    public static void main(String[] args) {
        double x1 = 2.0, x2=2.1, x3 = 2.0;
        int n1 = 10, n2 = 3, n3 = -2;

        // Using Math.pow(double, double) to calculate the result

        System.out.println(Math.pow(x1, n1));
        System.out.println(Math.pow(x2, n2));
        System.out.println(Math.pow(x3, n3));
    }
}
