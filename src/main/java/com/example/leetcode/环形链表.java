package com.example.leetcode;

import com.example.leetcode.common.ListNode;

/**
 * @author changwei.zheng
 * @date 2021/7/5 19:09
 * @describe
 */
public class 环形链表 {
  public static void main(String[] args) {
    ListNode listNode = ListNode.creatNode();
    System.out.println(hasCycle2(listNode));
    //
  }

  public static boolean hasCycle2(ListNode head) {
    if (head == null || head.next == null) {
      return false;
    }
    ListNode slow = head;
    ListNode fast = head.next;
    while (slow != fast) {
      if (fast == null || fast.next == null) {
        return false;
      }
      slow = slow.next;
      fast = fast.next.next;
    }
    return true;
  }

  public static boolean hasCycle(ListNode head) {
    if (head == null || head.next == null) {
      return false;
    }
    ListNode slow = head;
    ListNode fast = head.next;
    while (slow != fast) {
      if (fast == null || fast.next == null) {
        return false;
      }
      slow = slow.next;
      fast = fast.next.next;
    }
    return true;
  }
}
