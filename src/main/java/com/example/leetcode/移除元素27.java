package com.example.leetcode;

/**
 * @author changwei.zheng
 * @date 2021/7/7 16:44
 * @describe 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 *     <p>不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 *     <p>元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 */
public class 移除元素27 {
  public static void main(String[] args) {
    int[] nums = {3,3,3,2};
    int val = 3;
    int res = removeElement1(nums, val);
    for (int num : nums) {
      System.out.print(num + " ");
    }
    System.out.println();
    System.out.println(res);
  }
  public static int removeElement(int[] nums, int val) {
    int left = 0;
    for (int right = 0; right < nums.length; right++) {
      if (nums[right] != val) {
        nums[left] = nums[right];
        left++;
      }
    }
    return left;
  }
  public static int removeElement1(int[] nums, int val) {
    int left = 0;
    int right = nums.length;
    while (left < right) {
      if (nums[left] == val) {
        nums[left] = nums[right - 1];
        right--;
      } else {
        left++;
      }
    }
    return left;
  }
}
