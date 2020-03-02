package com.solution.leetcode;

public class LongestUniqueSubstring {
    public String LUS(String str) {
        boolean [] existingChar = new boolean[256];
        String resultString = "";
        int leftBound = 0, maxLen = 0;
        for (int rightBound = 0; rightBound < str.length(); rightBound++) {
            while(existingChar[str.charAt(rightBound)]) { // if left bound == right bound - matched character
                // increase left bound and update ascii map
                existingChar[str.charAt(leftBound)] = false;
                leftBound++;
            }
            existingChar[str.charAt(rightBound)] = true; // turn the flag on to indicate this character exist
            if (rightBound - leftBound + 1 > maxLen) { // update result string and max length
                resultString = str.substring(leftBound, rightBound + 1);
                maxLen = rightBound - leftBound + 1;
            }
        }
        return resultString;
    }

    public static void main(String [] args) {
        LongestUniqueSubstring runner = new LongestUniqueSubstring();
        System.out.println(runner.LUS("abcdef"));
        System.out.println(runner.LUS("hellojava"));
        System.out.println(runner.LUS("abcdeafg"));
        System.out.println(runner.LUS("abcaaadefg"));
    }
}
