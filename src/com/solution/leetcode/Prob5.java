package com.solution.leetcode;

// Longest palindromic substring.
public class Prob5 {
    private String longestSubstring = "";
    private void updatePalindromeReference(String newPalindome) {
        longestSubstring = newPalindome.length() > longestSubstring.length() ? newPalindome : longestSubstring;
    }
    public String runSolution(String s) {
        if (s.length() < 2) {
            return s;
        }
        if (s.length() == 2 && s.charAt(0) != s.charAt(1)) {
            return s.substring(0, 1);
        }
        for (int i = 1; i < s.length() - 2; i++) {
            int j = 1;

            // odd palindrome
            while (i - j >= 0 && i + j < s.length() - 1 && s.charAt(i - j) == s.charAt(i + j)) {
                j++;
            }
            String oddPalindrome = s.substring(i - (j - 1), i + j);
            updatePalindromeReference(oddPalindrome);

            // even palindrome
            int k = 1;
            while (i - k >= 0 && i + k <= s.length() && s.charAt(i - k) == s.charAt(i + k - 1)) {
                k++;
            }
            String evenPalindrome = s.substring(i - (k - 1), i + k);
            updatePalindromeReference(evenPalindrome);
        }
        return longestSubstring;
    }
}
