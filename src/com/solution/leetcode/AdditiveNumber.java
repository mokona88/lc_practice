package com.solution.leetcode;

public class AdditiveNumber {
    public static boolean isAdditiveNumber(String num) {
        boolean isAdditiveNo = true;
        for (int i = 2; i < num.length(); i++) {
            int currNo = num.charAt(i) - 48;
            int prevNo = num.charAt(i - 1) - 48;
            int prevNo2 = num.charAt(i - 2) - 48;
            if (currNo != prevNo + prevNo2) {
                isAdditiveNo = false;
            }
        }

        return isAdditiveNo;
    }
}
