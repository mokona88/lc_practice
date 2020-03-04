package com.solution.leetcode;

import com.solution.config.RunnerConfig;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.solution.config.RunnerConfig.ListNode;

/**
 * Created by squall on 3/30/20.
 */
public class Prob725SplitLinkedListTest {
  private ListNode root;
  private Prob725SplitLinkedList solver;
  private List<int []> expectedList = new ArrayList<int []>();

  @Before
  public void setup() {
    root = RunnerConfig.getInstance().getInput_725();
    solver = new Prob725SplitLinkedList();
    expectedList.add(new int[] {1, 2, 3});
    expectedList.add(new int[] {4, 5});
    expectedList.add(new int[] {6, 7});
  }

  @Test
  public void perform() {
    ListNode[] result = solver.splitListToParts(root, 3);
    int listIdx = 0;
    for (ListNode start : result) {
      int[] expectedResults = expectedList.get(listIdx);
      int resultIdx = 0;
      ListNode curr = start;
      while (curr != null) {
        Assert.assertEquals(expectedResults[resultIdx], curr.val);
        curr = curr.next;
        resultIdx++;
      }
      listIdx++;
    }
  }
}
