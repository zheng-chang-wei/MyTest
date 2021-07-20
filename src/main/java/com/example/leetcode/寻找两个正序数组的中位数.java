package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

public class 寻找两个正序数组的中位数 {

  List<String> res = new ArrayList<>();

  public static void main(String[] args) {
    double list = new 寻找两个正序数组的中位数().findMedianSortedArrays(new int[] {2, 4}, new int[] {1, 3});
    System.out.println(list);
  }

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int index1 = 0;
    int index2 = 0;
    int length1 = nums1.length;
    int length2 = nums2.length;
    int[] nums = new int[length1 + length2];
    int i = 0;
    while (true) {
      if (index1 < length1 && index2 < length2 && nums1[index1] < nums2[index2]) {
        nums[i] = nums1[index1];
        index1++;
      } else if (index2 < length2) {
        nums[i] = nums2[index2];
        index2++;
      } else if (index1 < length1) {
        nums[i] = nums1[index1];
        index1++;
      } else {
        break;
      }
      i++;
    }
    int mid = nums.length / 2;
    if (nums.length % 2 == 0) {
      return (nums[mid] + nums[mid - 1]) / 2.0;
    } else {
      return nums[mid];
    }
  }
}
