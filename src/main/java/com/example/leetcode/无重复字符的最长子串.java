package com.example.leetcode;

import java.util.HashMap;

/**
 * @author zcw
 * @date 2021/05/13
 * Description:
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例 1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 **/
public class 无重复字符的最长子串 {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for(int i = 0; i < s.length(); i ++){
            char value = s.charAt(i);
            if(map.containsKey(value)){
                left = Math.max(left,map.get(value) + 1);
            }
            map.put(value,i);
            max = Math.max(max,i-left+1);
        }
        return max;
    }
}
