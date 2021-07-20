package com.example.sort;

import com.example.leetcode.common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class 遍历二叉树 {

  public static void main(String[] args) {
    TreeNode root = TreeNode.createTree();
    System.out.println("前序遍历");
    pre(root);
    System.out.println();
    pre1(root);
    System.out.println();
    System.out.println("中序遍历");
    mid(root);
    System.out.println();
    mid1(root);
    System.out.println();
    System.out.println("后序遍历");
    post(root);
    System.out.println();
    post1(root);
    System.out.println("分层遍历");
    traverseTree(root);
  }

  private static void traverseTree(TreeNode root) {
    LinkedList<TreeNode> stack = new LinkedList<>();
    stack.push(root);
    while (!stack.isEmpty()) {
      TreeNode node = stack.removeLast();
      System.out.print(node.val + " ");
      if (node.left != null) {
        stack.push(node.left);
      }
      if (node.right != null) {
        stack.push(node.right);
      }
    }
  }

  /** 前序遍历 中左右 */
  private static void pre(TreeNode tree) {
    if (tree != null) {
      System.out.print(tree.val + " ");
      pre(tree.left);
      pre(tree.right);
    }
  }

  private static void pre1(TreeNode root) {
    Deque<TreeNode> deque = new LinkedList<>();
    deque.push(root);
    while (!deque.isEmpty()) {
      TreeNode node = deque.pop();
      System.out.print(node.val + " ");
      if (node.right != null) {
        deque.push(node.right);
      }
      if (node.left != null) {
        deque.push(node.left);
      }
    }
  }

  /** 中序遍历 左中右 */
  private static void mid(TreeNode tree) {
    if (tree != null) {
      mid(tree.left);
      System.out.print(tree.val + " ");
      mid(tree.getRight());
    }
  }

  private static void mid1(TreeNode root) {
    Deque<TreeNode> deque = new LinkedList<>();
    while (root != null || !deque.isEmpty()) {
      while (root != null) {
        deque.push(root);
        root = root.left;
      }
      root = deque.pop();
      System.out.print(root.val + " ");
      root = root.right;
    }
  }

  /** 后序遍历 左右中 */
  private static void post(TreeNode tree) {
    if (tree != null) {
      post(tree.getLeft());
      post(tree.getRight());
      System.out.print(tree.val + " ");
    }
  }

  private static void post1(TreeNode root) {
    Deque<TreeNode> deque1 = new LinkedList<>();
    Deque<TreeNode> deque2 = new LinkedList<>();
    deque1.push(root);
    while (!deque1.isEmpty()) {
      TreeNode node = deque1.pop();
      deque2.push(node);
      if (node.left != null) {
        deque1.push(node.left);
      }
      if (node.right != null) {
        deque1.push(node.right);
      }
    }
    while (!deque2.isEmpty()) {
      System.out.print(deque2.pop().val + " ");
    }
  }
}
