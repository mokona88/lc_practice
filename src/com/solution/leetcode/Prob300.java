package com.solution.leetcode;

import java.util.ArrayList;

// Find longest increasing subsequence
public class Prob300 {
    private ArrayList<Integer> trackingIdx = new ArrayList<>();

    public int lengthOfLIS(int [] nums) {
        findSequenceStartIdx(nums, 0, nums.length - 1);
        int longest = 0;
        for (Integer index : trackingIdx) {
            int j = index + 1;
            while(nums[j] > nums[index]) { j++; }
            longest = Math.max(j - index, longest);
        }
        return longest;
    }

    void findSequenceStartIdx(int []nums, int left, int right) {
        if (right - left <= 1) {
            if (nums[right] > nums[left] && left >= 0) {
                // 2 Use cases:
                // - left is at 0
                // - left the smallest between in comparison with its neighbor
                if (left - 1 >= 0 && nums[left - 1] > nums[left] || left == 0) {
                    trackingIdx.add(left);
                }
            }
            return;
        }

        int mid = (left + right) / 2;
        // if mid is one of the peaks, add it to tracking list.
        if (nums[mid - 1] > nums[mid] && nums[mid + 1] > nums[mid]) {
            trackingIdx.add(mid);
        }

        // search for other smaller peaks from both side of mid
        findSequenceStartIdx(nums, left, mid - 1);
        findSequenceStartIdx(nums, mid + 1, right);
    }
}
