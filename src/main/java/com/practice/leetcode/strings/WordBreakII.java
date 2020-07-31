package com.practice.leetcode.strings;

import java.util.ArrayList;
import java.util.List;

public class WordBreakII {
    public static void main(String[] args) {

        String s = "catsanddog";

        List<String> wordList = new ArrayList<>();
        wordList.add("cat");
        wordList.add("cats");
        wordList.add("and");
        wordList.add("sand");
        wordList.add("dog");

        List<String> result = new ArrayList<>();

        if (wordBreakcheck(s, wordList)) {
            wordBreakHelper(s, wordList, result, "", 0);
        }

        result.forEach(r -> System.out.println(r));


    }

    private static boolean wordBreakcheck(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                String str = s.substring(j, i);

                if (dp[j] && wordDict.contains(str)) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }

    private static void wordBreakHelper(String s, List<String> wordDict, List<String> result,
                         String item, int start) {
        if (start == s.length()) {
            result.add(item);
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = start; i < s.length(); i++) {
            sb.append(s.charAt(i));

            if (wordDict.contains(sb.toString())) {
                String newItem = "";

                if (item.length() > 0) {
                    newItem = item + " " + sb.toString();
                } else {
                    newItem = sb.toString();
                }

                wordBreakHelper(s, wordDict, result, newItem, i + 1);
            }
        }
    }
}