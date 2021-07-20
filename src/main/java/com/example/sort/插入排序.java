package com.example.sort;

/**
 * @author changwei.zheng
 * @date 2020/12/10 14:02
 * @describe
 */
public class 插入排序 {
  public static void main(String[] args) {
    int[] nums = {9, 3, 4, 2, 6, 7, 5, 1};
    insertionSort(nums);
    /*这个函数必须知道元素的个数，所以将元素个数传入。
    有心者可以在函数内部用sizeof求出元素个数 */
    for (int i = 0; i < nums.length; i++) {
      System.out.print(nums[i] + " ");
    }
    System.out.println();
  }

  private static void insertionSort(int[] a) {
    for (int i = 1; i < a.length; i++) {
      // 待插入元素
      int temp = a[i];
      int j;
      for (j = i - 1; j >= 0; j--) {
        // 将大于temp的往后移动一位
        if (a[j] > temp) {
          a[j + 1] = a[j];
        } else {
          break;
        }
      }
      a[j + 1] = temp;
    }
  }
}
