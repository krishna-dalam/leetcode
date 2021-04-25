package com.practice.leetcode.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class MathWorks {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        int n = sc.nextInt();
//
//        String input = sc.next();
//
//        System.out.println(n);
//        System.out.println(input);

        int n=4;
        List<String> input = new ArrayList<>();
        input.add("karthik");
        input.add("krishna");
        input.add("jagan");
        input.add("karthik");

        HashMap<String, Integer> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        for (String s : input) {
            int count = map.getOrDefault(s, 0);

            if (count != 0) {
                res.add(s + count);
            } else {
                res.add(s);
            }
            map.put(s, count + 1);
        }

        for(String e: res){
            System.out.println(e);
        }
    }
}
