//package com.practice.leetcode.strings;
//
///*
//
// */
//
//
//public class MultiplyTwoNumbers {
//    public static void main(String[] args) {
//        String x = "123";
//        String y = "456";
//
//        System.out.println(multiply(x, y));
//    }
//
//    private static String multiply(String x, String y) {
//        int xLen = x.length(), yLen = y.length();
//        if(x.isEmpty() && !y.isEmpty()){
//            return y;
//        }
//        if(y.isEmpty() && !x.isEmpty()) {
//            return x;
//        }
//        if(xLen == 1 && yLen == 1){
//            return String.valueOf(Integer.parseInt(x) * Integer.parseInt(y));
//        }
//        String a = x.substring(0, xLen/2);
//        String b = x.substring(xLen/2, xLen);
//        String c = y.substring(0, yLen/2);
//        String d = y.substring(yLen/2, yLen);
//
//        String ac = multiply(a, c);
//        String bd = multiply(b, d);
//        String aplusbXcplusd = multiply(
//                String.valueOf(add(a, b)),
//                String.valueOf(add(c, d))
//        );
//        String adPlusBc = subtract(aplusbXcplusd, add(ac, bd));
//        int bdLen = bd.length();
//        return ac + adPlusBc + bd;
//    }
//
//    private static String appendZeros(String str, int n){
//        int len = n + 1 - str.length();
//        return str + nZeros(len);
//    }
//    private static String nZeros(int n){
//        String res = "";
//        while(n>0){
//            res = res.concat("0");
//            n--;
//        }
//    }
//
//    private static String subtract(String a, int b) {
//        return String.valueOf(Integer.parseInt(a) - b);
//    }
//
//    private static int add(String a, String b){
//        if(a.isEmpty()){
//            return Integer.parseInt(b);
//        }
//        if(b.isEmpty()){
//            return Integer.parseInt(a);
//        }
//        return Integer.parseInt(a) + Integer.parseInt(b);
//    }
//
//}
