package com.practice.leetcode.tcsdigital;

import java.util.Scanner;

class Armstrong {
    public static void main(String[] args) {
        int num = 0, start = 0, end = 0, i = 0, rem = 0, temp = 0, counter=0;

        Scanner scanner = new Scanner(System.in);
        start = scanner.nextInt();
        end = scanner.nextInt();
        for(i=start+1; i<end; i++) {
            temp = i;
            num = 0;
            while(temp != 0) {
                rem = temp%10;
                num = num + rem*rem*rem;
                temp = temp/10;
            }
            if(i == num) {
                if(counter == 0)
                {
                    System.out.println("Armstrong Numbers Between the Given Interval are: ");
                }
                System.out.print(i + "  ");
                counter++;
            }
        }
        if(counter == 0) {
            System.out.print("Armstrong number not Found between the Given Interval.");
        }
    }
}
