package com.solution.leetcode;

public class UniquePaths {
    public static void main(String args[]) {
        UniquePaths uniquePaths = new UniquePaths();
        System.out.println(String.format("m=%d n=%d - rs=%d", 3, 2, uniquePaths.uniquePaths(3, 2)));
    }

    private int uniquePaths(int m, int n) {
        int arr[][] = new int[m][n];
        arr[m-1][n-1] = 0;
        for (int row = m - 1; row >= 0; --row) {
            for (int col = n - 1; col >= 0; --col) {
                if (row == m - 1)
                    arr[row][col] = 1;
                else if (col == n - 1)
                    arr[row][col] = 1;
                else
                    arr[row][col] = arr[row + 1][col] + arr[row][col + 1];
            }
        }
        return arr[0][0];
    }
}
