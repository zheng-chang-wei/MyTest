package com.example.leetcode;

import com.example.leetcode.common.ListNode;

import java.util.*;

/**
 * @author changwei.zheng
 * @date 2021/7/6 14:26
 * @describe 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 */
public class 移除重复节点 {

  public static void main(String[] args) {
    ListNode root = creatNode();
    removeDuplicateNodes(root);
    System.out.println(root.val);
    while (root.next != null) {
      System.out.println(root.next.val);
      root = root.next;
    }

    //
  }

  public static ListNode removeDuplicateNodes(ListNode head) {
    if (head==null){
      return null;
    }
    Set<Integer> cache = new HashSet<>();
    cache.add(head.val);
    while (head != null && head.next != null) {
      if (!cache.add(head.next.val)) {
        head.next = head.next.next;
      } else {
        head = head.next;
      }
    }
    return head;
  }

  private static ListNode creatNode() {
    ListNode listNode1 = new ListNode(1);
    ListNode listNode2 = new ListNode(2);
    ListNode listNode3 = new ListNode(3);
    ListNode listNode4 = new ListNode(3);
    ListNode listNode5 = new ListNode(2);
    ListNode listNode6 = new ListNode(1);

    listNode1.next = listNode2;
    listNode2.next = listNode3;
    listNode3.next = listNode4;
    listNode4.next = listNode5;
    listNode5.next = listNode6;

    return listNode1;
  }
}
