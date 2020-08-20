package com.solution.leetcode;

import static java.lang.Integer.MIN_VALUE;
import static java.lang.Integer.MAX_VALUE;

/**
 * Created by squall on 8/9/20.
 */
public class Prob08StringToInteger {
  boolean isDigit(char c) {
    return c >= '0' && c <= '9';
  }

  boolean isPlusSign(char c) {
    return c == '+';
  }

  boolean isMinusSign(char c) {
    return c == '-';
  }

  boolean isNumericSign(char c) {
    return isPlusSign(c) || isMinusSign(c);
  }

  boolean isSpace(char c) {
    return c == ' ';
  }

  boolean isDot(char c) {
    return c == '.';
  }

  int getIntValue(char c) {
    return c - '0';
  }

  boolean isValidNumeric(char c) {
    return isDigit(c) || isDot(c);
  }

  int getFinalResult(long num, int flag) {
    return num > MAX_VALUE ? (flag > 0 ? MAX_VALUE : MIN_VALUE) : (int)(num * flag);
  }

  public int myAtoi(String str) {
    if (str.length() == 0) return 0;
    if (str.length() == 1 && !isDigit(str.charAt(0))) {
      return 0;
    }
    int start = -1;
    int flag = 1;
    long num = 0;
    for (int i = 0; i < str.length(); i++) {
      if (start < 0) {
        if (!(isSpace(str.charAt(i))
          || isNumericSign(str.charAt(i))
          || isDigit(str.charAt(i)))) {
          return 0;
        }
        if (isDigit(str.charAt(i))) {
          start = i;
          num = getIntValue(str.charAt(i));
        }
        if (isNumericSign(str.charAt(i)) && !isDigit(str.charAt(i + 1))) {
          return 0;
        }
        if (isMinusSign(str.charAt(i))) {
          flag = -1;
        }
      } else {
        if (isSpace(str.charAt(i)) || isNumericSign(str.charAt(i))
          || !(isDigit(str.charAt(i)) || isDot(str.charAt(i)))) {
          break;
        }
        if (isDot(str.charAt(i))) {
          if (getIntValue(str.charAt(i + 1)) >= 5) {
            return getFinalResult(num + 1, flag);
          }
          else {
            return getFinalResult(num, flag);
          }
        }
        num = num * 10 + getIntValue(str.charAt(i));
        int checkResult = getFinalResult(num, flag);
        if (checkResult == MAX_VALUE || checkResult == MIN_VALUE) {
          return checkResult;
        }
      }
    }
    return getFinalResult(num, flag);
  }
}
