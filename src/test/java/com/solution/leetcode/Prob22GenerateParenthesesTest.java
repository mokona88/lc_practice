package com.solution.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by squall on 12/24/20.
 */
public class Prob22GenerateParenthesesTest {
  private Prob22GenerateParentheses solver;
  private List<String> expectedList = new ArrayList<>();
  String[] nIsFour = new String[] {"(((())))","((()()))","((())())","((()))()","(()(()))","(()()())","(()())()","(())(())","(())()()","()((()))","()(()())","()(())()","()()(())","()()()()"};

  @Before
  public void setup() {
    solver = new Prob22GenerateParentheses();
    Collections.addAll(expectedList, nIsFour);
  }

  @Test
  public void perform() {
    List<String> resultList = solver.generateParenthesis(4);
    Assert.assertEquals(expectedList.size(), resultList.size());
    for (String str : expectedList) {
      Assert.assertTrue(resultList.contains(str));
    }
  }
}
