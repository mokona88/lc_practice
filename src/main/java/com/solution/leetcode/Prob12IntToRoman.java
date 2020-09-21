package com.solution.leetcode;

public class Prob12IntToRoman {
    enum Type {
        M(1000), CM(900), D(500), CD(400), C(100), XC(90), L(50), XL(40), X(10), IX(9), V(5), IV(4), I(1);
        private final int value;
        Type(int value) {
            this.value = value;
        }
    }
    public String intToRoman(int num) {
        final StringBuilder builder = new StringBuilder();
        int numClone = num;
        int tenUnit = 0;
        while (numClone > 0) {
            int digit = numClone % 10;
            numClone /= 10;
            char unit = getTenthUnit(tenUnit);
            char middleUnit = getMiddleUnit(tenUnit);
            if (digit == 4) {
                builder.append(middleUnit + "" + unit);
            } else if (digit == 9) {
                builder.append(getTenthUnit(tenUnit + 1) + "" + unit);
            } else if (digit == 5) {
                builder.append(middleUnit);
            } else {
                int repAmount = digit - 5 < 0 ? digit : digit - 5;
                if (digit - 5 < 0) {
                    builder.append(getRomanUnit(unit, repAmount));
                } else {
                    builder.append(getRomanUnit(unit, repAmount) + middleUnit);
                }
            }
            tenUnit++;
        }
        return builder.reverse().toString();
    }

    private char getTenthUnit(int tenthValue) {
        switch (tenthValue) {
            case 0:
                return 'I';
            case 1:
                return 'X';
            case 2:
                return 'C';
            case 3:
                return 'M';
        }
        return 0;
    }

    private char getMiddleUnit(int tenthValue) {
        switch (tenthValue) {
            case 0:
                return 'V';
            case 1:
                return 'L';
            case 2:
                return 'D';
        }
        return 0;
    }

    private String getRomanUnit(char unit, int rep) {
        StringBuilder builder = new StringBuilder();
        switch (rep) {
            case 1:
                builder.append("" + unit);
                break;
            case 2:
                builder.append("" + unit + unit);
                break;
            case 3:
                builder.append("" + unit + unit + unit);
                break;
            default:
                break;
        }
        return builder.toString();
    }
}
