package com.example.leetcode;

/**
 * @author changwei.zheng
 * @date 2021/7/6 15:26
 * @describe
 */
public class 回文数 {
  public static void main(String[] args) {
    System.out.println(isPalindrome2(121));
  }

  public static boolean isPalindrome2(int x) {
    // 边界判断
    if (x < 0) return false;
    int div = 1;
    //
    while (x / div >= 10) {
      div *= 10;
    }
    while (x > 0) {
      int left = x / div;
      int right = x % 10;
      if (left != right) return false;
      x = (x % div) / 10;
      div /= 100;
    }
    return true;
  }

  public static boolean isPalindrome(int x) {
    if (x < 0 || (x % 10 == 0 && x != 0)) {
      return false;
    }
    int revertedNumber = 0;
    while (x > revertedNumber) {
      revertedNumber = revertedNumber * 10 + x % 10;
      x = x / 10;
    }
    return x == revertedNumber || x == revertedNumber / 10;
  }
}
