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


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReorderList {
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

        Map<Integer, Integer> m = new HashMap<>();

        ListNode p = head;
        int index = 0;
        while(p != null){
            m.put(index++, p.val);
            p = p.next;
        }

        ListNode newHead= new ListNode(m.get(0));
        p = newHead;
        for(int i=1; i<(index+1)/2; i++){
            p.next = new ListNode(m.get(index-i));
            p = p.next;

            p.next = new ListNode(m.get(i));
            p = p.next;
        }
        if(index%2 == 0)
            p.next = new ListNode(m.get(index/2));

        p = newHead;

        while(p != null){
            System.out.println(p.val);
            p = p.next;
        }

    }
}
