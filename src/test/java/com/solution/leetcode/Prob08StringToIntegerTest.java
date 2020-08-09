package com.solution.leetcode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by squall on 8/9/20.
 */
public class Prob08StringToIntegerTest {
  private Prob08StringToInteger prob8Instance;

  @Before
  public void setup() {
    prob8Instance = new Prob08StringToInteger();
  }

  @Test
  public void run() {
    assertEquals(47, prob8Instance.myAtoi("47"));
    assertEquals(-47, prob8Instance.myAtoi("-47"));
  }
}
