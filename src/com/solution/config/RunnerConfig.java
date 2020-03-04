package com.solution.config;

public class RunnerConfig {
  private static RunnerConfig configInstance;

  public char[][] getInput_36() {
    return new char[][]{
      {'.', '.', '.', '.', '.', '.', '5', '.', '.'},
      {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
      {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
      {'9', '3', '.', '.', '2', '.', '4', '.', '.'},
      {'.', '.', '7', '.', '.', '.', '3', '.', '.'},
      {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
      {'.', '.', '.', '3', '4', '.', '.', '.', '.'},
      {'.', '.', '.', '.', '.', '3', '.', '.', '.'},
      {'.', '.', '.', '.', '.', '5', '2', '.', '.'}
    };
  }

  public ListNode getInput_725() {
    int[] input = {1, 2, 3, 4, 5, 6, 7};
    ListNode head = null, tail = null;
    for (int val : input) {
      if (tail == null) {
        tail = new ListNode(val);
      }
      else {
        tail.next = new ListNode(val);
        tail = tail.next;
      }
      if (head == null) {
        head = tail;
      }
    }

    return head;
  };

  public static RunnerConfig getInstance() {
    if (configInstance == null) {
      configInstance = new RunnerConfig();
    }
    return configInstance;
  }

  static public class ListNode {
    // For problem 725
    public int val;
    public ListNode next;

    public ListNode(int x) {
      val = x;
    }
  }
}