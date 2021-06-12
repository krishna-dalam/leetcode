package com.practice.leetcode.strings;

import java.util.*;
import java.util.stream.Collectors;

public class FunWithAnagrams {
    public static void main(String[] args) {
        List<String> text = new ArrayList<>();
        text.add("code");
        text.add("doce");
        text.add("ecod");
        text.add("framer");
        text.add("frame");

        List<String> result = new ArrayList<>();
        result.add(text.get(0));

        Set<String> unique = new HashSet<>();
        text.forEach(s -> {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            unique.add(String.valueOf(chars));
        });


        System.out.println(result.stream().sorted().collect(Collectors.toList()));
    }

    public static boolean checkAnagram(String s1, String s2)
    {
        // Remove all the white space
        s1 = s1.replaceAll("\\s", "");
        s2 = s2.replaceAll("\\s", "");

        // Check if both length matches
        if(s1.length() != s2.length())
            return false;
        else
        {
            // Convert both Strings into lower case and into Character Array
            char[] arr1 = s1.toLowerCase().toCharArray();
            char[] arr2 = s2.toLowerCase().toCharArray();

            // Sort both Character Array
            Arrays.sort(arr1);
            Arrays.sort(arr2);

            // Check if both arrays are equal
            return (Arrays.equals(arr1, arr2));
        }
    }
}
