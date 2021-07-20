package com.example.leetcode;

import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author zcw @Description: 时间复杂度 O(nlogk)
 * @date 2021-07-1921:47
 */
public class 第k大的数 {
  public static void main(String[] args) {
    int[] arr = {1, 9, 3, 2, 6, 8, 4, 11, 13, 45};
    System.out.println(getK(5, arr));
  }

  private static int getK(int k, int[] nums) {
    PriorityQueue<Integer> queue = new PriorityQueue<>();
    for (int i : nums) {
      queue.offer(i);
      if (queue.size()>k){
        queue.poll();
      }
    }
    return queue.peek();
  }

  private static void sort(int k, List<Integer> list, int i) {
    if (list.size() == k) {
      if (list.get(k - 1) < i) {
        list.set(k - 1, i);
        Collections.sort(list, (a, b) -> b - a);
      }
    } else {
      list.add(i);
      if (list.size() == k) {
        Collections.sort(list, (a, b) -> b - a);
      }
    }
  }
}
