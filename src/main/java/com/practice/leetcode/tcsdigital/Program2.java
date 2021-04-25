package com.practice.leetcode.tcsdigital;

import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if(num<0 || num>1000000)
            System.out.print("Wrong Input");
        else {
            String res = getResult(num);
            System.out.print(Integer.valueOf(res));
        }


    }

    private static String getResult(int num) {
        String str = String.valueOf(num);
        String res = "";
        for(char c: str.toCharArray()){
            res += 9 - Integer.parseInt(String.valueOf(c));
        }
        return res;
    }
}
