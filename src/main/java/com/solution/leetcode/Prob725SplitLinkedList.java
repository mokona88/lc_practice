package com.solution.leetcode;

import com.solution.config.RunnerConfig;

import static com.solution.config.RunnerConfig.ListNode;

/*
 * Created by squall on 3/2/20.
 */
public class Prob725SplitLinkedList implements Runner {
  private int calListSize(ListNode root) {
    int size = 0;
    ListNode curr = root;
    while (curr != null) {
      size++;
      curr = curr.next;
    }
    return size;
  }

  public ListNode[] splitListToParts(ListNode root, int k) {
    if (root == null) {
      return new ListNode[] {};
    }
    int listSize = calListSize(root);
    int subSize = listSize / k;
    int rem = listSize % k;
    ListNode[] list = new ListNode[k];
    ListNode curr = root;
    for (int i = 0; i < k; i++) {
      list[i] = curr;
      // the idea of binary operator is for adding all extra nodes of the remaining
      // to any first encounter list.
      for (int j = 0; j < subSize - 1 + (i < rem ? 1 : 0); j++) {
        if (curr != null) curr = curr.next;
      }
      if (curr != null) {
        ListNode tmp = curr.next;
        curr.next = null;
        curr = tmp;
      }
    }
    return list;
  }

  public void perform() {
    System.out.println("Problem 725:" + this.getClass().getName());
    ListNode[] splittedLinkList = splitListToParts(RunnerConfig.getInstance().getInput_725(), 3);
    System.out.print('[');
    for (ListNode list : splittedLinkList) {
      printList(list);
      System.out.print(',');
    }
    System.out.print("]\n");
  }

  private void printList(ListNode start) {
    System.out.print('[');
    while (start != null) {
      System.out.print(start.val + ",");
      start = start.next;
    }
    System.out.print(']');
  }
}
