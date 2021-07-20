package com.example.leetcode;

import com.example.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author changwei.zheng
 * @date 2021/7/5 17:49
 * @describe
 */
public class 遍历二叉树四种方式 {
  public static void main(String[] args) {
    List<Integer> list = new ArrayList<>();
    TreeNode root = TreeNode.createTree();
    post(root, list);
    for (Integer integer : list) {
      System.out.print(integer + " ");
    }
    System.out.println();
    post1(TreeNode.createTree());
  }

  /**
   * 前序遍历 中左右
   *
   * @param node
   * @param list
   */
  private static void pre(TreeNode node, List<Integer> list) {
    if (node != null) {
      list.add(node.val);
      pre(node.left, list);
      pre(node.right, list);
    }
  }

  private static void pre1(TreeNode root) {
    LinkedList<TreeNode> list = new LinkedList<>();
    list.push(root);
    while (!list.isEmpty()) {
      root = list.pop();
      System.out.print(root.val + " ");
      if (root.right != null) {
        list.push(root.right);
      }
      if (root.left != null) {
        list.push(root.left);
      }
    }
  }

  /**
   * 中序遍历 左中右
   *
   * @param node
   * @param list
   */
  private static void mid(TreeNode node, List<Integer> list) {
    if (node != null) {
      mid(node.left, list);
      list.add(node.val);
      mid(node.right, list);
    }
  }

  private static void mid1(TreeNode root) {
    LinkedList<TreeNode> list = new LinkedList<>();
    while (root != null || !list.isEmpty()) {
      while (root != null) {
        list.push(root);
        root = root.left;
      }
      TreeNode node = list.pop();
      System.out.print(node.val + " ");
      root = node.right;
    }
  }

  /**
   * 后序遍历 左右中
   *
   * @param node
   * @param list
   */
  private static void post(TreeNode node, List<Integer> list) {
    if (node != null) {
      post(node.left, list);
      post(node.right, list);
      list.add(node.val);
    }
  }

  private static void post1(TreeNode root) {
    LinkedList<TreeNode> list1 = new LinkedList<>();
    LinkedList<TreeNode> list2 = new LinkedList<>();
    list1.push(root);
    while (!list1.isEmpty()) {
      TreeNode node = list1.pop();
      list2.push(node);
      if (node.left != null) {
        list1.push(node.left);
      }
      if (node.right != null) {
        list1.push(node.right);
      }
    }
    while (!list2.isEmpty()){
      System.out.print(list2.pop().val+" ");
    }
  }

  /**
   * 分层遍历
   *
   * @param node
   * @param list
   */
  private static void leveOrder(TreeNode node, List<Integer> list) {
    LinkedList<TreeNode> linkedList = new LinkedList<>();
    linkedList.add(node);
    while (!linkedList.isEmpty()) {
      TreeNode root = linkedList.pop();
      list.add(root.val);
      if (root.left != null) linkedList.add(root.left);
      if (root.right != null) linkedList.add(root.right);
    }
  }
}
