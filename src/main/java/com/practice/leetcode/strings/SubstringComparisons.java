package com.practice.leetcode.strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class SubstringComparisons {
    public static void main(String[] args) {
        String s = "welcometojava";



        int len = s.length();
        String[] strings = new String[len-2];


        for(int i=0; i<len-2; i++){
            strings[i] = s.substring(i, i+3);
        }

        for(int i=0; i<len-2; i++){

        }

        for(String ss: strings){
            System.out.println(ss);
        }
    }
}
