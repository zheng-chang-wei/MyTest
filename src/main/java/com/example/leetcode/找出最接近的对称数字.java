package com.example.leetcode;

import java.util.Scanner;

/**
 * @author changwei.zheng
 * @date 2021/3/4 15:20
 * @describe
 */
public class 找出最接近的对称数字 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s = sc.nextLine();
    if (s.length() <= 1) {
      System.out.println(s);
      return;
    }
    if (isTenNPower(s)) {
      String r = "";
      while (r.length() < s.length() - 1) r += "9";
      System.out.println(r);
      return;
    }
    StringBuilder str = new StringBuilder(s);
    StringBuilder sb = new StringBuilder(s).reverse();
    int n = s.length();
    str.replace(n / 2, n, sb.substring(n / 2, n)); // 把前半段反过来拷到后半段
    System.out.println(str);
  }

    /**
     * 是否为10的N次幂
     */
  private static boolean isTenNPower(String s) {
    boolean flag = true;
    if (s.charAt(0) != '1') flag = false;
    if (s.charAt(0) == '1') {
      for (int i = 1; i < s.length(); ++i) {
        if (s.charAt(i) != '0') {
          flag = false;
          break;
        }
      }
    }
    return flag;
  }
}
