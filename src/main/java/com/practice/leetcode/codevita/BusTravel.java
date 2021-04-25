package com.practice.leetcode.codevita;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class BusTravel {
    public static void main(String[] args) {
//        int n = 5;
//        String[] str = {"A B R|-", "C|B", "D|A C", "-|D", "-|R"};
//        int t = 5;
//        int[][] sd = {{1, 2}, {1, 4}, {2, 4}, {2, 3}, {3, 4}};

        int n = 4;
        String[] str = {"A B|-", "C|-", "-|A B", "-|C"};
        int t = 3;
        int[][] sd = {{1, 3}, {1, 2}, {2, 3}};

//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        ArrayList<String> str = new ArrayList<>();
//        for(int i=0; i<N; i++){
//            str.add(sc.next());
//        }
//        int T = sc.nextInt();
//        int[][] sd = new int[T][2];
//        for(int i=0; i<T; i++){
//            sd[i][0] = sc.nextInt();
//            sd[i][1] = sc.nextInt();
//        }
        Boolean[] ticketAllocation = new Boolean[t];
        Arrays.fill(ticketAllocation, Boolean.FALSE);

        ArrayList<String> res = new ArrayList<>();

        int stopCount = 0;
        Map<String, Integer> personToTicketMap = new HashMap<>();
        Map<Integer, Map<Integer, Integer>> ticketSrcDestMap = new HashMap<>();

        for(int i=1; i<= t; i++){
            Map<Integer, Integer> srcDestPair = new HashMap<>();
            srcDestPair.put(sd[i-1][0], sd[i-1][1]);
            ticketSrcDestMap.put(i, srcDestPair);
        }

        for(String s: str){
            stopCount++;
            String[] srcDestNames = s.split("\\|");
            String[] srcNames = srcDestNames[0].split(" ");
            String[] destNames = srcDestNames[1].split(" ");

            if(isDash(srcNames) || isDash(destNames)){
                if(isDash(srcNames) && isDash(destNames)){
                    continue;
                } else if (isDash(srcNames)) {
                    for(String name: destNames){
                        calculateFare(name, stopCount, personToTicketMap, ticketSrcDestMap, res, ticketAllocation);
                        personToTicketMap.remove(name);
                    }
                } else {
                    for(String name: srcNames)
                        personToTicketMap.put(name, stopCount);
                }
            } else {
                for(String name: srcNames)
                    personToTicketMap.put(name, stopCount);
                for(String name: destNames){
                    calculateFare(name, stopCount, personToTicketMap, ticketSrcDestMap, res, ticketAllocation);
                    personToTicketMap.remove(name);
                }
            }

        }

        for(int i=0; i<res.size()-1; i++){
            System.out.println(res.get(i));
        }
        System.out.print(res.get(res.size()-1));

    }

    private static boolean isDash(String[] srcNames) {
        return srcNames.length == 1 && srcNames[0].equals("-");
    }

    private static void calculateFare(String name, int deststop, Map<String, Integer> personToTicketMap,
                                      Map<Integer, Map<Integer, Integer>> ticketSrcDestMap, ArrayList<String> results,
                                      Boolean[] ticketAllocation) {
        Integer srcStop = personToTicketMap.get(name);
        int validTicketId = getValidTicket(srcStop, deststop, ticketSrcDestMap, ticketAllocation);
        if(validTicketId != -1){
            Map<Integer, Integer> srcDestPair = ticketSrcDestMap.get(validTicketId);
            int key = srcDestPair.keySet().iterator().next();
            if(!isValidTicket(srcStop, key, deststop, srcDestPair.get(key))){
                if(isOverTravel(srcStop, key, srcDestPair.get(key), deststop)){
                    if(srcStop < key)
                        results.add(name + " " + srcStop + " " + key + " OT" );
                    if(deststop > srcDestPair.get(key))
                        results.add(name + " " + srcDestPair.get(key) + " " + deststop + " OT" );
                } else {
                    if(srcStop > key)
                        results.add(name + " " + srcStop + " " + key + " UT" );
                    if(deststop < srcDestPair.get(key))
                        results.add(name + " " + deststop + " " + srcDestPair.get(key) + " UT" );
                }
            }
        }

    }

    private static int getValidTicket(int srcStop, int deststop, Map<Integer, Map<Integer, Integer>> ticketSrcDestMap,
                                          Boolean[] ticketAllocation) {
        AtomicInteger res = new AtomicInteger();

        for(int key: ticketSrcDestMap.keySet()) {
            Map<Integer, Integer> srcDestPair = ticketSrcDestMap.get(key);
            int srckey = srcDestPair.keySet().iterator().next();
            if (srcStop == srckey && deststop == srcDestPair.get(srckey) && !ticketAllocation[key - 1]) {
                res.set(key);
                ticketAllocation[key - 1] = true;
                break;
            }
        }

        if(res.get() == 0)
            for(int key: ticketSrcDestMap.keySet()) {
                Map<Integer, Integer> srcDestPair = ticketSrcDestMap.get(key);
                int srckey = srcDestPair.keySet().iterator().next();
                if (srcStop == srckey && !ticketAllocation[key - 1]) {
                    res.set(key);
                    ticketAllocation[key - 1] = true;
                    break;
                }
            }

        if(res.get() == 0)
            for(int key: ticketSrcDestMap.keySet()) {
                Map<Integer, Integer> srcDestPair = ticketSrcDestMap.get(key);
                int srckey = srcDestPair.keySet().iterator().next();
                if(deststop == srcDestPair.get(srckey) && !ticketAllocation[key - 1]){
                    res.set(key);
                    ticketAllocation[key - 1] = true;
                    break;
                }
            }

        if(res.get() == 0)
            for(int i=0; i<ticketAllocation.length; i++){
                if(!ticketAllocation[i]){
                    res.set(i+1);
                    ticketAllocation[i]=true;
                }
            }
        return res.get();
    }

    private static boolean isOverTravel(int src1, int src2, int dest1, int dest2) {
        return dest2 > dest1 || src1 < src2;
    }

    private static boolean isValidTicket(int src1, int src2, int dest1, int dest2){
        return src1 == src2 && dest1 == dest2;
    }
}
