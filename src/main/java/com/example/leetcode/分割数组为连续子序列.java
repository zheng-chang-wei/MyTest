package com.example.leetcode;

import java.util.*;

/**
 * @author changwei.zheng
 * @date 2020/12/4 11:21
 * @describe 给你一个按升序排序的整数数组 num（可能包含重复数字），请你将它们分割成一个或多个子序列， 其中每个子序列都由连续整数组成且长度至少为 3 。如果可以完成上述分割，则返回
 *     true ；否则，返回 false 。 输入: [1,2,3,3,4,5] 输出: True 解释: 你可以分割出这样两个连续子序列 : 1, 2, 3 3, 4, 5
 */
public class 分割数组为连续子序列 {
  public static void main(String[] args) {
    分割数组为连续子序列 main = new 分割数组为连续子序列();
    int[] nums = {1, 2, 3, 3, 4, 5};
    main.isPossible(nums);
  }

  public boolean isPossible(int[] nums) {
    Map<Integer, PriorityQueue<Integer>> map = new HashMap<Integer, PriorityQueue<Integer>>();
    for (int x : nums) {
      if (!map.containsKey(x)) {
        map.put(x, new PriorityQueue<Integer>());
      }
      if (map.containsKey(x - 1)) {
        int prevLength = map.get(x - 1).poll();
        if (map.get(x - 1).isEmpty()) {
          map.remove(x - 1);
        }
        map.get(x).offer(prevLength + 1);
      } else {
        map.get(x).offer(1);
      }
    }
    Set<Map.Entry<Integer, PriorityQueue<Integer>>> entrySet = map.entrySet();
    for (Map.Entry<Integer, PriorityQueue<Integer>> entry : entrySet) {
      PriorityQueue<Integer> queue = entry.getValue();
      if (queue.peek() < 3) {
        return false;
      }
    }
    return true;
  }
}
