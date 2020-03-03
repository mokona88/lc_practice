package com.solution.leetcode;

import com.solution.config.RunnerConfig;

public class Prob36ValidateSudoku implements Runner {
    private boolean[] exist = new boolean[256];

    private void resetReference() {
        exist = new boolean[256];
    }

    private int convertToNumber(char c) {
        return c - 48 >= 0 ? c - 48 : c;
    }

    private boolean checkNumberExist(int num) {
        return num >= 0 && num <= 9 && exist[num];
    }

    private boolean validateRow(int index, char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (checkNumberExist(convertToNumber(board[index][i]))) {
                resetReference();
                return false;
            }
            exist[convertToNumber(board[index][i])] = true;
        }
        resetReference();
        return true;
    }

    private boolean validateColumn(int index, char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (checkNumberExist(convertToNumber(board[i][index]))) {
                resetReference();
                return false;
            }
            exist[convertToNumber(board[i][index])] = true;
        }
        resetReference();
        return true;
    }

    private boolean validateBoxes(int row, char[][] board) {
        for (int col = 0; col < 9; col += 3) {
            for (int i = row; i < row + 3; i++) {
                for (int j = col; j < col + 3; j++) {
                    if (checkNumberExist(convertToNumber(board[i][j]))) {
                        resetReference();
                        return false;
                    }
                    exist[convertToNumber(board[i][j])] = true;
                }
            }
            resetReference();
        }
        return true;
    }

    private boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (!validateRow(i, board))
                return false;
            if (!validateColumn(i, board))
                return false;
            if (i == 0 || i == 3 || i == 6) {
                if (!validateBoxes(i, board)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void perform() {
      System.out.println("Problem 36:" + this.getClass().getName());
        System.out.println(isValidSudoku(RunnerConfig.getInstance().getInput_36()));
    }
}
