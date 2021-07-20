package com.example.leetcode;

/**
 * @author changwei.zheng
 * @date 2020/12/14 19:20
 * @describe
 */
public class 最长回文子串 {
  public static void main(String[] args) {
    String str = "babad";
    long l = System.currentTimeMillis();
    String s = longestPalindrome2(str);
    System.out.println(System.currentTimeMillis() - l);
    System.out.println(s);
  }

  public static String longestPalindrome(String s) {
    if (s.length() == 1) {
      return s;
    }
    String max = "";
    for (int i = 0; i < s.length(); i++) {
      for (int j = i + max.length() + 1; j <= s.length(); j++) {
        String substring = s.substring(i, j);
        if (isPalindrome(substring) && substring.length() > max.length()) {
          max = substring;
        }
      }
    }

    return max;
  }

  private static boolean isPalindrome(String str) {
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
        return false;
      }
    }
    return true;
  }

  public static String longestPalindrome2(String s) {
    if (s == null || s.length() == 0) {
      return "";
    }
    // 保存起始位置，测试了用数组似乎能比全局变量稍快一点
    int[] range = new int[2];
    char[] str = s.toCharArray();
    for (int i = 0; i < s.length(); i++) {
      // 把回文看成中间的部分全是同一字符，左右部分相对称
      // 找到下一个与当前字符不同的字符
      i = findLongest(str, i, range);
    }
    return s.substring(range[0], range[1] + 1);
  }

  public static int findLongest(char[] str, int low, int[] range) {
    // 查找中间部分
    int high = low;
    while (high < str.length - 1 && str[high + 1] == str[low]) {
      high++;
    }
    // 定位中间部分的最后一个字符
    int ans = high;
    // 从中间向左右扩散
    while (low > 0 && high < str.length - 1 && str[low - 1] == str[high + 1]) {
      low--;
      high++;
    }
    // 记录最大长度
    if (high - low > range[1] - range[0]) {
      range[0] = low;
      range[1] = high;
    }
    return ans;
  }
}
