package com.example.leetcode;

/**
 * @author changwei.zheng
 * @date 2021/7/7 15:15
 * @describe 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 *     <p>如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 *     <p>假设环境不允许存储 64 位整数（有符号或无符号）。 -231 <= x <= 231 - 1
 */
public class 整数反转 {
  public static void main(String[] args) {
    System.out.println(reverse(-2147483412));
    System.out.println(String.valueOf(Integer.MIN_VALUE));
    System.out.println(String.valueOf(Integer.MAX_VALUE));
  }

  public static int reverse(int x) {
    int reverse = 0;
    while (x != 0) {
      try {
        reverse = Math.addExact(reverse * 10, x % 10);
      } catch (Exception e) {
        return 0;
      }
      x /= 10;
    }
    return reverse;
  }
}
