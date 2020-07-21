package com.practice.leetcode.linkedlists;

/*
    Remove Linked List Elements

    Remove all elements from a linked list of integers that have value val.

    Example:
    Input:  1->2->6->3->4->5->6, val = 6
    Output: 1->2->3->4->5

    Example:
    Input:  1->2->2->1, val = 2
    Output: 1->1

    Example:
    Input:  1, val = 1
    Output: null

    Example:
    Input:  1, val = 2
    Output: 1

 */


class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class RemoveLinkedListElements {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(6);
        ListNode listNode4 = new ListNode(3);
        ListNode listNode5 = new ListNode(4);
        ListNode listNode6 = new ListNode(5);
        ListNode listNode7 = new ListNode(6);

        head.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;

        int val = 6;

        ListNode helper = new ListNode(0);
        helper.next = head;
        ListNode p = helper;

        while(p.next != null){
            if(p.next.val == val){
                ListNode next = p.next;
                p.next = next.next;
            }else{
                p = p.next;
            }
        }

        ListNode curr =  helper.next;

        while (curr != null){
            System.out.println(curr.val);
            curr = curr.next;
        }

    }
}
