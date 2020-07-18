package com.practice.leetcode.math;

/*
    Angle Between Hands of a Clock

    Given two numbers, hour and minutes. Return the smaller angle (in degrees) formed between the hour and the minute hand.

    Example 1:
    Input: hour = 12, minutes = 30
    Output: 165

    Example 2:
    Input: hour = 3, minutes = 30
    Output: 75

    Example 3:
    Input: hour = 3, minutes = 15
    Output: 7.5

    Example 4:
    Input: hour = 4, minutes = 50
    Output: 155

    Example 5:
    Input: hour = 12, minutes = 0
    Output: 0

 */

/*
    Movement of minutes hand = M * 360/60                      => 6o min in an hour
    Movement of hour hand    = H * 360/12 + M * 360/60 * 1/12  => 12 hours in a min + rate of hour hand movement wrt min hand
    Difference of above is the result ( if less han 180 )
 */


public class AngleBetweenHandsOfAClock {
    public static void main(String[] args) {
        int h1 = 3, m1 = 15;
        double hourHandDegrees = h1 * (360/12) + m1 * (360/60) * (1.0/12);
        double minHandDegrees = m1 * (360/60);
        double diff = Math.abs(hourHandDegrees - minHandDegrees);
        if(diff > 180)
            System.out.println(360-diff);
        else
            System.out.println(diff);

    }
}
