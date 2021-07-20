package com.example.leetcode.common;

/**
 * @author changwei.zheng
 * @date 2021/7/7 18:32
 * @describe
 */
public class ListNode {

  public int val;

  public ListNode next;

  public ListNode(int x) {
    val = x;
  }

  public static ListNode creatNode() {
    ListNode listNode1 = new ListNode(2);
    ListNode listNode2 = new ListNode(4);
    ListNode listNode3 = new ListNode(3);
    ListNode listNode4 = new ListNode(5);
    listNode1.next = listNode2;
    listNode2.next = listNode3;
    listNode3.next = listNode4;
    listNode4.next = listNode1;
    return listNode1;
  }
}
