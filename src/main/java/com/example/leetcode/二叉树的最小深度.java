package com.example.leetcode;

import com.example.leetcode.common.TreeNode;

import java.util.LinkedList;

/**
 * @author changwei.zheng
 * @date 2021/7/21 11:59
 * @describe
 */
public class 二叉树的最小深度 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.createTree();
        System.out.println(minDepth(root));
        System.out.println(maxDepth2(root));
    }

    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int min_depth = Integer.MAX_VALUE;
        if (root.left != null) {
            min_depth = Math.min(minDepth(root.left), min_depth);
        }
        if (root.right != null) {
            min_depth = Math.min(minDepth(root.right), min_depth);
        }
        return min_depth + 1;
    }

    public static int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.addFirst(root);
        int ans = 1;
        while (!linkedList.isEmpty()) {
            int size = linkedList.size();
            while (size > 0) {
                TreeNode node = linkedList.removeLast();
                if (node.left == null && node.right == null) {
                    return ans;
                }
                if (node.left != null) {
                    linkedList.addFirst(node.left);
                }
                if (node.right != null) {
                    linkedList.addFirst(node.right);
                }
                size--;
            }
            ans++;
        }
        return ans;
    }
}
