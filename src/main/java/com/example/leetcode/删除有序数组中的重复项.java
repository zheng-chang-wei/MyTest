package com.example.leetcode;

/**
 * @author changwei.zheng
 * @date 2021/7/6 16:03
 * @describe 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 *     <p>不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 */
public class 删除有序数组中的重复项 {
  public static void main(String[] args) {
    int[] nums = {1, 1, 2, 2, 3};
    System.out.println(removeDuplicates(nums));
  }

  public static int removeDuplicates(int[] nums) {
    int end = 1;
    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i] != nums[i + 1]) {
        nums[end] = nums[i + 1];
        end++;
      }
    }
    return end;
  }
}
