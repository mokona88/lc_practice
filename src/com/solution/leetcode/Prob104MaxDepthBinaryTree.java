package com.solution.leetcode;

import com.solution.config.RunnerConfig;
import com.solution.config.RunnerConfig.TreeNode;

public class Prob104MaxDepthBinaryTree implements Runner {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return 1 + (leftDepth > rightDepth ? leftDepth : rightDepth);
    }

    @Override
    public void perform() {
        System.out.println("Problem 104: ");
        System.out.println("Max depth of input tree is: " + maxDepth(RunnerConfig.getInstance().getInput_104()));
    }
}
