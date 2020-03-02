package com.solution.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LexicalGraphicalOrderSolution {

    public static void main(String args[]) {
        LexicalGraphicalOrderSolution sol = new LexicalGraphicalOrderSolution();
        System.out.println(sol.lexicalOrder(1000));
    }

    private List<Integer> lexicalOrder(int n) {
        List<Integer> resultList = new ArrayList<>();
        for (int i = 1; i < 10; i++)
            dfs(i, n, resultList);
        return resultList;
    }

    private void dfs (int curr, int n, List<Integer> arrays) {
        if (curr > n)
            return;
        arrays.add(curr);
        for (int i = 0; i < 10; i++) {
            if (10 * curr + i > n)
                return;
            dfs(10*curr + i, n, arrays);
        }
    }
}
