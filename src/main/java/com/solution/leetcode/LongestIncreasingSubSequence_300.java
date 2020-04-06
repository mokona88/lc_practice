package com.solution.leetcode;

import java.util.ArrayList;

public class LongestIncreasingSubSequence_300 {
    private ArrayList<Integer> trackingIdx = new ArrayList<>();

    public int lengthOfLIS(int[] nums) {
        findAllLowestPeaks(nums, 0, nums.length - 1);
        return 0;
    }

    void findAllLowestPeaks(int[] nums, int left, int right) {
        if (left == right) {
            if (left == 0 && nums[left + 1] > nums[left]) {
                trackingIdx.add(left);
            }
        }

        if (right - left == 1 && nums[left] < nums[right] && (nums[left - 1] < nums[left] || nums[left] == 0)) {
            trackingIdx.add(left);
        }

        int mid = (left + right) / 2;
        if (nums[mid] < nums[mid+1] && nums[mid] < nums[mid - 1]) {
            trackingIdx.add(mid);
        }

        findAllLowestPeaks(nums, left, mid - 1);
        findAllLowestPeaks(nums, mid + 1, right);
    }
}
