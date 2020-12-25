package com.solution.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by squall on 12/20/20.
 */
public class Prob22GenerateParentheses {
  private static Map<Integer, List<String>> sizeToResultListMap = new HashMap<>();
  private static final char OPEN_PARENTHESIS = '(';
  private static final char CLOSE_PARENTHESIS = ')';

  Prob22GenerateParentheses() {
    if (sizeToResultListMap.size() == 0) {
      sizeToResultListMap.put(1, asList("()"));
    }
  }

  private List<String> asList(String... str) {
    return Arrays.asList(str);
  }

  /**
   * Return a list with all generated strings for given n. If n is invalid, an empty list is returned instead.
   * @param n {int} - the amount of parentheses pairs in each string to be generated.
   * */
  public List<String> generateParenthesis(int n) {
    // if result exist, early quit.
    List<String> generateList = sizeToResultListMap.get(n - 1);
    if (generateList != null) {
      return generateList;
    }

    updateSizeToResultMap(n);

    return sizeToResultListMap.get(n);
  }

  private void updateSizeToResultMap(int n) {
    List<String> prevList = sizeToResultListMap.get(n - 1);
    if (prevList == null) {
      updateSizeToResultMap(n - 1);
    }
    prevList = sizeToResultListMap.get(n - 1);

    Set<String> newList = new HashSet<>();
    for (String str : prevList) {
      newList.add(addParenthesis(str, 0));
      newList.add("(" + str + ")");
      for (int i = 1; i < str.length(); i++) {
        if (str.charAt(i) == ')') {
          newList.add(addParenthesis(str, i));
        }
      }
    }
    sizeToResultListMap.put(n, newList.stream().collect(Collectors.toList()));
  }

  /**
   * Generate a new string with a new pair parenthesis wrapped around a specific character at provided location.
   * @param str {String} - the given input string
   * @param location {int} - the character location to be wrapped with new parenthesis
   */
  private String addParenthesis(String str, int location) {
    StringBuilder builder = new StringBuilder(str);
    if (location == 0) {
      builder.insert(0, new char[] {OPEN_PARENTHESIS, CLOSE_PARENTHESIS});
    } else {
      if (location == str.length()) {
        builder.append(CLOSE_PARENTHESIS);
      } else {
        builder.insert(location + 1, CLOSE_PARENTHESIS);
      }
      builder.insert(location, OPEN_PARENTHESIS);
    }
    return builder.toString();
  }
}
