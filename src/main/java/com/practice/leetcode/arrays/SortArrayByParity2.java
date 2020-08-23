package com.practice.leetcode.arrays;

public class SortArrayByParity2 {
    public static void main(String args[])
    {
        int a[]= {1,2,3,4};
        int[] b=new int[a.length];

        int k=0;
        int l=a.length-1;

        for (int value : a) {
            if (value % 2 == 0)
                b[k++] = value;
            else
                b[l--] = value;
        }

        for (int i : b) System.out.print(i);

    }
}
