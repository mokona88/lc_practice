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
    assertEquals(1234, prob8Instance.myAtoi("1234 haha"));
    assertEquals(47, prob8Instance.myAtoi("47"));
    assertEquals(-47, prob8Instance.myAtoi("-47"));
    assertEquals(1, prob8Instance.myAtoi("+1"));
    assertEquals(Integer.MIN_VALUE, prob8Instance.myAtoi("-6147483648"));
    assertEquals(4193, prob8Instance.myAtoi("4193 with words"));
    assertEquals(25, prob8Instance.myAtoi("25.2"));
    assertEquals(26, prob8Instance.myAtoi("25.7"));
    assertEquals(1, prob8Instance.myAtoi("1"));
    assertEquals(0, prob8Instance.myAtoi("0"));
    assertEquals(Integer.MAX_VALUE, prob8Instance.myAtoi("9223372036854775808"));
  }
}
