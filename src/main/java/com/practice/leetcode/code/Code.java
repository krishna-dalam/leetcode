package com.practice.leetcode.code;

import java.util.Scanner;

public class Code {

    public static void main(String[] args) {
//        int m1 = 115, m2 = 130, r1 = 110;
//        int m1Am2 = 85, m1Ar1 = 75, m2Ar1 = 95;
//
//        int m1Am2Ar1 = 70;

        Scanner sc = new Scanner(System.in);

        int m1 = sc.nextInt();
        int m2 = sc.nextInt();
        int r1 = sc.nextInt();
        int m1Am2 = sc.nextInt();
        int m1Ar1 = sc.nextInt();
        int m2Ar1 = sc.nextInt();
        int m1Am2Ar1 = sc.nextInt();


        System.out.println(r1 - (m1Am2Ar1 + ( m1Ar1 - m1Am2Ar1 ) + (m2Ar1 - m1Am2Ar1)));
        System.out.println(m1Am2 - m1Am2Ar1);

    }
}
