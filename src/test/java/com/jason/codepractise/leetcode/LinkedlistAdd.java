package com.jason.codepractise.leetcode;


class ListNode {
    ListNode next;
    int val;

    public ListNode(int val) {
        this.val = val;
    }
}

public class LinkedlistAdd {

    private ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode r = root;
        int carry = 0;
        int s, x, y = 0;

        while (l1 != null || l2 != null) {
            x = l1 != null ? l1.val : 0;
            y = l2 != null ? l2.val : 0;
            s = carry + x + y;
            carry = s % 100 / 10;
            r.next = new ListNode(s % 10);
            r = r.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        if (carry > 0) {
            r.next = new ListNode(1);
        }
        return root.next;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode two = new ListNode(4);
        ListNode third = new ListNode(5);
        head.next = two;
        two.next =third;
        ListNode head1 = new ListNode(3);
        ListNode two1 = new ListNode(6);
        ListNode third1 = new ListNode(3);
        head1.next = two1;
        two1.next =third1;
        ListNode ln = new LinkedlistAdd().addTwoNumbers(head, head1);
        while (ln != null) {
            System.out.println(ln.val);
            ln = ln.next;
        }
    }
}
