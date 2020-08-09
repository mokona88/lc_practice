package com.solution.leetcode;

// Longest palindromic substring.
public class Prob5 {
  private String longestSubstring = "";

  private void updatePalindromeReference(String newPalindome) {
    longestSubstring = newPalindome.length() > longestSubstring.length() ? newPalindome : longestSubstring;
  }

  public String runSolution(String s) {
    if (longestSubstring.length() > 0) { // empty cache before running
      longestSubstring = "";
    }
    System.out.println("Input String: " + s);
    if (s.length() < 2) {
      return s;
    }
    if (s.length() == 2) {
      if (s.charAt(0) != s.charAt(1)) {
        return s.substring(0, 1);
      } else {
        return s;
      }
    }
    for (int index = 0; index < s.length() - 1; index++) {
      if (index > 0) { // odd palindromic substring starts with index = 1
        int oddDistance = 0;

        while (index - (oddDistance + 1) >= 0 && index + (oddDistance + 1) <= s.length() - 1
          && s.charAt(index - (oddDistance + 1)) == s.charAt(index + (oddDistance + 1))) {
          oddDistance++;
        }

        // A string with only one character is an odd palindromic string
        int left = index - oddDistance;
        int right = index + oddDistance;
        String oddPalindrome = s.substring(left, right + 1);
        updatePalindromeReference(oddPalindrome);
      }

      // even palindrome
      int evenDistance = 0;
      while (index - evenDistance >= 0 && index + evenDistance + 1 < s.length()
        && s.charAt(index - evenDistance) == s.charAt(index + evenDistance + 1)) {
        evenDistance++;
      }
      if (evenDistance > 0) {
        int left = index - (evenDistance - 1), right = index + evenDistance + 1;
        String evenPalindrome = s.substring(left, right);
        updatePalindromeReference(evenPalindrome);
      }
    }
    return longestSubstring;
  }
}
