package com.example.leetcode;

/**
 * @author changwei.zheng
 * @date 2021/7/5 15:00
 * @describe
 */
public class X的平方根 {

  public static void main(String[] args) {
    int x = 9;
    double sqrt = Math.sqrt(x);
    System.out.println(mySqrt(x));
  }

  public static double mySqrt(int x) {
    if (x == 0) return 0;
    double C = x, x0 = x;
    while (true) {
      double res = (x0 + C / x0) / 2;
      if (res == x0) {
        return x0;
      }
      x0 = res;
    }
  }
}
