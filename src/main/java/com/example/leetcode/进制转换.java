package com.example.leetcode;

/**
 * @author changwei.zheng
 * @date 2021/3/4 16:12
 * @describe
 */
public class 进制转换 {
  public static void main(String[] args) {
    int n = 31;
    System.out.println(n + "的二进制是:" + Integer.toBinaryString(n));
    System.out.println(n + "的八进制是:" + Integer.toOctalString(n));
    System.out.println(n + "的十六进制是:" + Integer.toHexString(n));
    System.out.println(n + "的三进制是:" + Integer.toString(n, 32));
    String s1 = solve(n, 16);
    System.out.println(s1);
  }

  private static char[] array = {
    '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
  };
  /**
   * 进制转换
   *
   * @param M int整型 给定整数
   * @param N int整型 转换到的进制
   * @return string字符串
   */
  public static String solve(int M, int N) {
    if (M == 0) {
      return "0";
    }
    StringBuilder result = new StringBuilder();
    boolean isNegative = false;
    if (M < 0) {
      M = -M;
      isNegative = true;
    }
    // 模拟计算进制的过程
    while (M > 0) {
      int i = M % N;
      result.append(array[i]);
      M /= N;
    }
    if (isNegative) {
      result.append("-");
    }
    return result.reverse().toString();
  }
}
