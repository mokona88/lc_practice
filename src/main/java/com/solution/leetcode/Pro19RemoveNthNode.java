package com.solution.leetcode;

import static com.solution.config.RunnerConfig.ListNode;

/**
 * Given a linked list, remove the n-th node from the end of list and return its head
 *
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 */
public class Pro19RemoveNthNode {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    if (null == head.next && 1 == n) {
      return null;
    }
    ListNode curr = head, currNth = head, preCurr = head;
    for (int i = 0; i < n - 1; i++) {
      currNth = currNth.next;
    }

    // traverse the list
    while (null != currNth.next) {
      curr = curr.next;
      currNth = currNth.next;
      if (preCurr.next != curr) {
        preCurr = preCurr.next;
      }
    }

    // drop off current node from list
    // If traverse is done and preCurr == curr. Then they both must reference head node, update head.
    if (curr == head) {
      head = head.next;
      return head;
    }
    preCurr.next = curr.next;

    return curr;
  }
}