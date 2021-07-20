package com.example.leetcode;

public class 只出现一次的数字 {

	public static void main(String[] args) {
		int[] nums = { 4, 1, 2, 1, 2, 4, 5 };
		System.out.println(singleNumber(nums));
	}

	public static int singleNumber(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			if (!isContent(nums, i)) {
				return nums[i];
			}
		}
		return 0;

	}

	private static boolean isContent(int[] nums, int i) {
		for (int j = 0; j < nums.length; j++) {
			if (i != j && nums[i] == nums[j]) {
				return true;
			}
		}
		return false;
	}
}
