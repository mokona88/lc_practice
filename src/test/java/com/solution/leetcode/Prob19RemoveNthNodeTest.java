package com.solution.leetcode;

import com.solution.config.RunnerConfig;
import com.solution.leetcode.Pro19RemoveNthNode;
import com.solution.leetcode.utilities.ListUtil;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static com.solution.config.RunnerConfig.ListNode;
import static org.junit.Assert.assertEquals;

/**
 * Created by squall on 8/6/20.
 */
public class Prob19RemoveNthNodeTest {
  private ListNode root;
  private Pro19RemoveNthNode solver;
  private int[] expectedList;

  @Before
  public void setup() {
    root = RunnerConfig.getInstance().getInput_19(); // reuse existing setup
    solver = new Pro19RemoveNthNode();
    expectedList = new int [] {1, 2, 3, 4, 5, 7};
  }

  @Test
  public void perform() {
    ListNode removedNode = solver.removeNthFromEnd(root, 2);
    ListUtil.validateIntegerListContent(Arrays.stream(expectedList).boxed().collect(Collectors.toList()), root);
    assertEquals("Compare value", 6, removedNode.val);
  }
}
