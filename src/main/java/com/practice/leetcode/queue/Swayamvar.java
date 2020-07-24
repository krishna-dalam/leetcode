package com.practice.leetcode.queue;

import java.util.LinkedList;
import java.util.Queue;

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
