package com.practice.leetcode.codevita;

import java.util.Scanner;

public class Pipe {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Number of input pipes
        int N = sc.nextInt();
        // Number of output ipes
        int M = sc.nextInt();
        // Rust
        int R = sc.nextInt();

        // Actual value = Rated value - Rust

        int sum1 = 0;
        int sum2 = 0;
        // Input pipes rated values
        for(int i=0; i<N; i++){
            sum1+=(sc.nextInt() - R);
        }
        // Output pipes rated values
        for(int i=0; i<M; i++){
            sum2+=(sc.nextInt() - R);
        }


        int diff = sum2 - sum1;
        //check if junction is balanced (output values sum  = input values sum)
        // else print rated value of pipe that needs to be added to make junction balanced
        if(Math.abs(diff) == 0){
            System.out.println("BALANCED");
        } else {
            System.out.println(diff<0 ? diff-R : diff+R );
        }
    }
}
