package com.practice.leetcode.queue;

import java.util.LinkedList;
import java.util.Queue;

/*
    Swayamvar

    Bride and Bridegrooms stand in a queue. Bridge has a lucky chance to choose her Bridegroom but conditions apply.
    1. The alcohol type of Bride should match with Bridegroom.
       There are 2 alcohol types namely r and m
    2. If a Bride cannot find a groom every other bride waiting next to her in the queue will not get married.

    Example 1:
     Input:
      brides = "rrmm"
      bridegrooms = "mrmr"
     Output:
      0

    Example 2:
     Input:
      brides = "rmrm"
      bridegrooms = "mmmr"
     Output:
      2
     Explanation:
      Bride at first place only marries groom who drinks rum. So, groom joins back of queue and this will repeat until
      match is not found. Since there is no 2nd r in the grooms list r and m will be unmarried

 */

public class Swayamvar {
    public static void main(String[] args) {
        int n= 4;
        String brides = "rrmm";
        String bridegrooms = "mrmr";

        Queue<Character> bridesQueue = new LinkedList<>();
        Queue<Character> bridegroomsQueue = new LinkedList<>();

        brides.chars().forEach(c -> bridesQueue.add((char)c));
        bridegrooms.chars().forEach(c -> bridegroomsQueue.add((char)c));

        int count = bridegroomsQueue.size();
        int loopCount = 0;

        while(!bridesQueue.isEmpty() && count != 0){
            loopCount++;
            if(bridesQueue.peek() == bridegroomsQueue.peek()){
                bridesQueue.remove();
                bridegroomsQueue.remove();
                count = bridegroomsQueue.size();
            }else{
                char bridegroom = bridegroomsQueue.remove();
                bridegroomsQueue.add(bridegroom);
                count--;
            }
        }

        System.out.println(bridesQueue);
        System.out.println(bridegroomsQueue);
        System.out.println(loopCount);
    }

}
