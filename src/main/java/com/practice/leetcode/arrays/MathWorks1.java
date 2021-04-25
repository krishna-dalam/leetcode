package com.practice.leetcode.arrays;

public class MathWorks1 {
    public static void main(String[] args) {
        String s = "xyz"; // yza -> zaa -> aaa
        int[] roll = {3, 2, 1};

        for(int i: roll){
            s = roll(s, i);
        }

        System.out.println(s);
    }

    private static String roll(String s, int n) {

        StringBuilder res = new StringBuilder();

        for(int i=0; i<n; i++){
            char c1;
            int ascii = s.charAt(i);
            if(ascii != 122){
                c1 = (char) (ascii + 1);
            }else{
                c1 = 'a';
            }
            res.append(c1);
        }
        return res.toString() + s.substring(n);
    }
}
