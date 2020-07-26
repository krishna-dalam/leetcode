package com.practice.leetcode.linkedlists;

/*

    Add Two Numbers

    You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse
    order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

    You may assume the two numbers do not contain any leading zero, except the number 0 itself.

    Example:

        Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
        Output: 7 -> 0 -> 8
        Explanation: 342 + 465 = 807.

 */

public class AddTwoNumbers {

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public static void main(String[] args) {
        ListNode l11 = new ListNode(9);
        ListNode l12 = new ListNode(8);
        ListNode l13 = new ListNode(7);
        ListNode l14 = new ListNode(6);
        ListNode l15 = new ListNode(5);

        l11.next = l12;
        l12.next = l13;
        l13.next = l14;
        l14.next = l15;

        ListNode l21 = new ListNode(9);
        ListNode l22 = new ListNode(8);
        ListNode l23 = new ListNode(7);
        ListNode l24 = new ListNode(6);
        ListNode l25 = new ListNode(5);

        l21.next = l22;
        l22.next = l23;
        l23.next = l24;
        l24.next = l25;



        ListNode currL1 = l11;
        ListNode currL2 = l21;

        int carry = 0;

        ListNode result = new ListNode(0);
        ListNode p = result;

        while(currL1 != null || currL2 != null){

            int sum = (currL1 != null ? currL1.val : 0) + (currL2 != null ? currL2.val : 0) + carry;

            ListNode temp;
            if(sum >= 10){
                carry = sum/10;
                temp = new ListNode(sum % 10);
            } else{
                carry = 0;
                temp = new ListNode(sum);
            }


            p.next = temp;

            p = p.next;

            if(currL1 != null)
                currL1 = currL1.next;
            if(currL2 != null)
                currL2 = currL2.next;
        }

        if(carry != 0) {
            p.next = new ListNode(carry);
        }

        result = result.next;
        while (result!=null){
            System.out.println(result.val);
            result = result.next;
        }

    }
}
