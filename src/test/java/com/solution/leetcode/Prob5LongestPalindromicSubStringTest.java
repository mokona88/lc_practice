package com.solution.leetcode;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by squall on 8/8/20.
 */
public class Prob5LongestPalindromicSubStringTest {
  private Prob5 prob5Instance;
  private Map<String, String> samples = new HashMap<>(); // map inputs to expected values.

  @Before
  public void prepare() {
    prob5Instance = new Prob5();
    samples.put("bb", "bb");
    samples.put("cbb", "bb");
    samples.put("babad", "bab");
    samples.put("ccd", "cc");
  }

  @Test
  public void run() {
    System.out.println("Test String: 01234567. Substring(2, 5) value is '" + "01234567".substring(2, 5) + "'." );
    for (Map.Entry entry : samples.entrySet()) {
      String result = prob5Instance.runSolution((String) entry.getKey());
      assertEquals(entry.getValue(), result);
    }
  }
}
