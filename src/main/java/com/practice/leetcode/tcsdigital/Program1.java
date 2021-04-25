package com.practice.leetcode.tcsdigital;

import java.awt.image.SinglePixelPackedSampleModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] output = new int[N];
        int onesCount = 0;
        int twosCount = 0;
        for(int i=0; i<N; i++){
            int val = sc.nextInt();
            if(val == 1)
                onesCount++;
            if(val == 2)
                twosCount++;
        }
        for(int i=0; i<onesCount; i++){
            output[i] = 1;
        }
        for(int i=N-twosCount; i<N; i++){
            output[i] = 2;
        }

        for(int i=0; i<N-1; i++){
            System.out.print(output[i] + " ");
        }
        System.out.print(output[N-1]);
    }
}
