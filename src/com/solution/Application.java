package com.solution;

import com.solution.leetcode.Prob36ValidateSudoku;
import com.solution.leetcode.Prob725SplitLinkedList;
import com.solution.leetcode.Runner;

public class Application {
  public static void main(String[] args) {
    Runner problem36 = new Prob36ValidateSudoku();
    problem36.perform();
    Runner problem725 = new Prob725SplitLinkedList();
    problem725.perform();
  }
}
