package com.example.sort;

import java.util.Arrays;

/**
 * @author changwei.zheng
 * @date 2020/12/10 11:35
 * @describe
 */
public class 冒泡排序 {
  public static void main(String[] args) {
    sort1();
//    sort2();
//    sort3();
//    sort4();
    sort5();
  }

  private static void sort1() {

    int[] nums = {1, 2, 3, 5, 6, 7};
    sort1(nums);
    for (int num : nums) {
      System.out.print(num + " ");
    }
    System.out.println();
  }

  private static void sort2() {
    int[] nums = {4, 2, 1, 5, 6, 7};
    sort2(nums);
    for (int num : nums) {
      System.out.print(num + " ");
    }
    System.out.println();
  }

  private static void sort3() {
    int[] nums = {4, 2, 1, 5, 6, 7};
    sort3(nums);
    for (int num : nums) {
      System.out.print(num + " ");
    }
    System.out.println();
  }

  private static void sort4() {
    int[] nums = {4, 2, 1, 5, 6, 7};
    sort4(nums);
    for (int num : nums) {
      System.out.print(num + " ");
    }
    System.out.println();
  }

  private static void sort5() {
    int[] nums = {1, 2, 3, 5, 6, 7};
    sort(nums);
    for (int num : nums) {
      System.out.print(num + " ");
    }
    System.out.println();
  }

  private static void sort(int[] nums) {
    int count = 0;
    int lastExchangeIndex = 0;
    int sortBorder = nums.length - 1;
    boolean isSorted=true;
    for (int i = 0; i < nums.length - 1; i++) {
      for (int j = 0; j < sortBorder; j++) {
        if (nums[j] > nums[j + 1]) {
          int temp = nums[j + 1];
          nums[j + 1] = nums[j];
          nums[j] = temp;
          lastExchangeIndex = j;
          isSorted=false;
        }
        count++;
      }
      if (isSorted){
        break;
      }
      sortBorder = lastExchangeIndex;
    }
    System.out.println(count);
  }

  private static void sort1(int[] nums) {
    int count = 0;
    for (int i = 0; i < nums.length; i++) {
      for (int j = 0; j < nums.length - i - 1; j++) {
        if (nums[j] > nums[j + 1]) {
          int temp = nums[j + 1];
          nums[j + 1] = nums[j];
          nums[j] = temp;
        }
        count++;
      }
    }
    System.out.println(count);
  }

  private static void sort2(int[] nums) {
    int count = 0;
    for (int i = 0; i < nums.length; i++) {
      boolean isSorted = true;
      for (int j = 0; j < nums.length - i - 1; j++) {
        if (nums[j] > nums[j + 1]) {
          int temp = nums[j + 1];
          nums[j + 1] = nums[j];
          nums[j] = temp;
          isSorted = false;
        }
        count++;
      }
      if (isSorted) {
        break;
      }
    }
    System.out.println(count);
  }

  private static void sort3(int[] nums) {
    int lastExchangeIndex = 0;
    int sortBorder = nums.length - 1;
    int count = 0;
    for (int i = 0; i < nums.length; i++) {
      boolean isSorted = true;
      for (int j = 0; j < sortBorder; j++) {
        if (nums[j] > nums[j + 1]) {
          int temp = nums[j + 1];
          nums[j + 1] = nums[j];
          nums[j] = temp;
          isSorted = false;
          lastExchangeIndex = j;
        }
        count++;
      }
      sortBorder = lastExchangeIndex;
      if (isSorted) {
        break;
      }
    }
    System.out.println(count);
  }

  private static void sort4(int[] nums) {
    boolean sorted1 = true;
    boolean sorted2 = true;
    int length = nums.length;
    int count = 0;
    for (int i = 0; i < length / 2; i++) {
      sorted1 = true;
      sorted2 = true;
      for (int j = 0; j < length - 1 - j; j++) {
        if (nums[j] > nums[j + 1]) {
          int temp = nums[j];
          nums[j] = nums[j + 1];
          nums[j + 1] = temp;
          sorted1 = false;
        }
        count++;
      }
      for (int j = length - 1 - i; j > i; j--) {
        if (nums[j] < nums[j - 1]) {
          int temp = nums[j];
          nums[j] = nums[j - 1];
          nums[j - 1] = temp;
          sorted2 = true;
        }
        count++;
      }
      if (sorted1 && sorted2) { // 减少趟数，已有序则结束
        break;
      }
    }
    System.out.println(count);
  }

  public static int[] maoPaoUpSort(int[] a) {
    int left = 0, right = a.length - 1;
    int temp = 0;
    int count = 0;
    while (left < right) {
      for (int i = left; i < right; i++) {
        if (a[i] > a[i + 1]) {
          temp = a[i + 1];
          a[i + 1] = a[i];
          a[i] = temp;
        }
        count++;
      }
      right--;
      for (int i = right; i > left; i--) {
        if (a[i - 1] > a[i]) {
          temp = a[i];
          a[i] = a[i - 1];
          a[i - 1] = temp;
        }
        count++;
      }
      left++;
    }
    System.out.println(count);
    return a;
  }
}
