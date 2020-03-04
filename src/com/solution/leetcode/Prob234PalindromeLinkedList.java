package com.solution.leetcode;

import com.solution.config.RunnerConfig.ListNode;

public class Prob234PalindromeLinkedList implements Runner {
    private CustomList revertedList(ListNode head) {
        int listSize = 0;
        ListNode revertedHead = null;
        ListNode current = head;
        while (current != null) {
            ListNode revertedNode = new ListNode(current.val);
            revertedNode.next = revertedHead;
            revertedHead = revertedNode;
            current = current.next;
            listSize++;
        }
        return new CustomList(revertedHead, listSize);
    }

    public boolean isPalindrome(ListNode head) {
        CustomList customRevertedList = revertedList(head);
        int loopVariant;
        if (customRevertedList.size % 2 == 0) {
            loopVariant = customRevertedList.size / 2;
        }
        else {
            loopVariant = customRevertedList.size / 2 + 1;
        }
        ListNode currentHead = head;
        ListNode revertedHead = customRevertedList.node;
        for (int i = 0; i < loopVariant; i++) {
            if (currentHead.val != revertedHead.val) {
                return false;
            }
            currentHead = currentHead.next;
            revertedHead = revertedHead.next;
        }
        return true;
    }

    @Override
    public void perform() {
        System.out.println("Hello World");
    }

    private class CustomList {
        ListNode node;
        int size;
        CustomList(ListNode node, int size) {
            this.node = node;
            this.size = size;
        }
    }
}
