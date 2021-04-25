package com.practice.leetcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

public class CuttingARod {

    static class Employee implements Comparable<Employee>{
        int id;
        String name;
        Employee(){}
        Employee(int id, String name){
            this.name = name;
        }
        int getId(){
            return id;
        }
        void setId(int id){
            this.id = id;
        }
        String getName(){
            return name;
        }
        void setName(String name){
            this.name = name;
        }

        @Override
        public int compareTo(Employee o) {
            return this.id - o.getId();
        }
    }
    public static void main(String[] args) {
//        StringBuilder builder = new StringBuilder();
//        StringBuffer buffer = new StringBuffer();
//        String s = new String();
//        Employee employee = new Employee(1, "karthik");
//        Employee employee1 = new Employee(1, "karthik");
//        TreeSet<Employee> treeSet = new TreeSet<>();
//        treeSet.add(employee);
//        treeSet.add(employee1);
////        System.out.println(treeSet.size());
////        System.out.println(employee.toString());
//
//        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, 2, 3 , 4));
//        System.out.println(arr.stream().reduce(0, Integer::sum));


//        Thread.sl
    }
}
