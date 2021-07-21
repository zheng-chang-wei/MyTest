package com.example.leetcode;

import com.example.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author changwei.zheng
 * @date 2021/7/21 9:28
 * @describe
 */
public class 二叉树的最大深度 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.createTree();
        System.out.println(maxDepth(root));
        System.out.println(maxDepth2(root));
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int deptLeft = maxDepth(root.left);
        int deptRight = maxDepth(root.right);
        return Math.max(deptLeft, deptRight) + 1;
    }

    public static int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.addFirst(root);
        int ans = 0;
        while (!linkedList.isEmpty()) {
            int size = linkedList.size();
            while (size > 0) {
                TreeNode node = linkedList.removeLast();
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
