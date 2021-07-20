package com.example.leetcode;

/**
 * @author changwei.zheng
 * @date 2021/7/9 13:40
 * @describe
 */
public class 最大子序和 {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -4, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
      int pre = 0, maxAns = nums[0];
      for (int x : nums) {
        pre = Math.max(pre + x, x);
        maxAns = Math.max(maxAns, pre);
      }

      return maxAns;
    }
}
