package com.example.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author changwei.zheng
 * @date 2020/9/30 10:34
 * @describe
 */
public class 两数之和 {
  public static void main(String[] args) {
    int[] nums = {2, 3, 3, 15};
    int[] x = twoSum3(nums, 6);
    System.out.println(x[0] + "  " + x[1]);
  }

  public static int[] twoSum(int[] nums, int target) {
    int[] results = new int[2];
    for (int i = 0; i < nums.length - 1; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] + nums[j] == target) {
          results[0] = i;
          results[1] = j;
          return results;
        }
      }
    }
    return results;
  }
  public static int[] twoSum3(int[] nums, int target) {
    Map<Integer,Integer> map=new HashMap<>();
    int[] results = new int[2];
    for(int i=0;i<nums.length;i++){
      int aa=target-nums[i];
      if(map.containsKey(aa)){
        return new int[]{map.get(aa),i};
      }
      map.put(nums[i],i);
    }
    return results;
  }





  public static int[] twoSum2(int[] nums, int target) {
    int[] results = new int[2];
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];
      if (map.containsKey(complement)) {
        return new int[] {map.get(complement), i};
      }
      map.put(nums[i],i);
    }
    return results;
  }
}
