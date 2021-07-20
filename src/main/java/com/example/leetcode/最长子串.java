package com.example.leetcode;

import java.util.HashMap;
import java.util.Map;

public class 最长子串 {

  public static void main(String[] args) {
    最长子串 最长子串 = new 最长子串();
    String a = "abcabcbb";
    int lengthOfLongestSubstring = 最长子串.lengthOfLongestSubstring3(a);
    System.out.println(lengthOfLongestSubstring);
  }

  public int lengthOfLongestSubstring3(String s) {
    int max = 0;
    Map<Character, Integer> map = new HashMap<>(); // current index of character
    int left = 0;
    for (int i = 0; i < s.length(); i++) {
      char key = s.charAt(i);
      if (map.containsKey(key)) {
        left = Math.max(map.get(key) + 1, left);
      }
      max = Math.max(max, i - left + 1);
      map.put(key, i);
    }
    return max;
  }

  public int lengthOfLongestSubstring2(String s) {
    int ans = 0;
    Map<Character, Integer> map = new HashMap<>(); // current index of character
    for (int j = 0, i = 0; j < s.length(); j++) {
      char key = s.charAt(j);
      if (map.containsKey(key)) {
        i = Math.max(map.get(key), i);
      }
      ans = Math.max(ans, j - i + 1);
      map.put(key, j + 1);
    }
    return ans;
  }

  public int lengthOfLongestSubstring(String a) {
    if (a.length() == 0) {
      return 0;
    }
    return getAllChildren(a);
  }

  private static int getAllChildren(String a) {
    int max = 1;
    for (int i = 0; i < a.length(); i++) {
      for (int j = i + max; j < a.length(); j++) {
        String substring = a.substring(i, j + 1);
        if (!isContainRepeat(substring)) {
          if (max < substring.length()) {
            max = substring.length();
          }
        } else {
          break;
        }
      }
    }
    return max;
  }

  private static boolean isContainRepeat(String value) {
    char[] charArray = value.toCharArray();
    for (char c : charArray) {
      if (value.indexOf(c) != value.lastIndexOf(c)) {
        return true;
      }
    }
    return false;
  }
}
