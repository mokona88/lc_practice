package com.solution.leetcode;

import static com.solution.config.RunnerConfig.ListNode;

public class Prob206ReverseLinkedList implements Runner {
    public ListNode reverseList(ListNode head) {
        ListNode headRev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = headRev;
            headRev = curr;
            curr = nextNode;
        }
        return headRev;
    }

    @Override
    public void perform() {
        System.out.println("Hello World");
    }
}
