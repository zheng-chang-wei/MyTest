package com.example.leetcode.common;

public class TreeNode {
  public int val;
  public TreeNode left;
  public TreeNode right;

  public TreeNode() {}

  public TreeNode(int val) {
    this.val = val;
  }

  public TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }

  public static TreeNode createTree() {
    TreeNode root = new TreeNode(1);
    TreeNode left = new TreeNode(2);
    root.left = left;
    TreeNode right = new TreeNode(3);
    root.right = right;
    left.left = new TreeNode(4);
    left.right = new TreeNode(5);
    right.left = new TreeNode(6);
    right.right = new TreeNode(7);
    return root;
  }
}