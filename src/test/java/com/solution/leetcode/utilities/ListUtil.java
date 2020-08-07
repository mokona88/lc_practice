package com.solution.leetcode.utilities;

import java.util.List;

import static com.solution.config.RunnerConfig.ListNode;
import static org.junit.Assert.assertEquals;

/**
 * Created by squall on 8/6/20.
 */
public class ListUtil {
  public static void validateIntegerListContent(List<Integer> expectedData,ListNode toBeValidatedList) {
    for (Integer item : expectedData) {
      assertEquals(item, new Integer(toBeValidatedList.val));
      toBeValidatedList = toBeValidatedList.next;
    }
  }
}
