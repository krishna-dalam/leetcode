package com.practice.leetcode.linkedlists;

/*
    Given a singly linked list L: L0→L1→…→Ln-1→Ln,
    reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

    You may not modify the values in the list's nodes, only nodes itself may be changed.

    Example 1:
        Given 1->2->3->4, reorder it to 1->4->2->3.
    Example 2:
        Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 */

public class ReorderList2 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);

        head.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
//        listNode4.next = listNode5;

        ListNode p = head;
        int index = 0;
        while(p != null){
            index++;
            p = p.next;
        }
        p = head;
        for(int i=1; i<(index+1)/2; i++){
            ListNode next = p.next;
            p.next = findNode(index-1, head);
            p = p.next;
            p.next = next;
            p = p.next;
        }
        if(index%2 == 0){
            p.next = findNode(index-1, head);
            p = p.next;
        }
        p.next = null;
        p = head;
        while(p != null){
            System.out.println(p.val);
            p = p.next;
        }
    }

    private static ListNode findNode(int n, ListNode head){
        int i=0;
        ListNode p = head;
        while(i < n){
            p = p.next;
            i++;
        }
        return p;
    }
}
