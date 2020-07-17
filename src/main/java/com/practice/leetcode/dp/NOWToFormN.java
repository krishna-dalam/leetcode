package com.practice.leetcode.dp;

// Number of ways to form m

/*
    Given 3 numbers {1, 3, 5}, we need to tell
    the total number of ways we can form a number 'N'
    using the sum of the given three numbers.
    (allowing repetitions and different arrangements).
 */
public class NOWToFormN {
    public static void main(String[] args) {
        for(int i=1; i<=8; i++){
            System.out.println(solve(i));
        }
    }
    static int solve(int n)
    {
        // base case
        if (n < 1)
            return 0;
        if (n == 1)
            return 1;

        return solve(n-1) + solve(n-3) + solve(n-5);
    }
}
