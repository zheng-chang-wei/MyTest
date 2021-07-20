package com.example.leetcode;

import com.example.leetcode.common.TreeNode;

import java.util.LinkedList;

/**
 * @author changwei.zheng
 * @date 2021/7/20 10:17
 * @describe
 */
public class 路径总和 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.createTree();
        System.out.println(hasPathSum2(root, 7));
        System.out.println(hasPathSum2(root, 8));
        System.out.println(hasPathSum2(root, 9));
        System.out.println(hasPathSum2(root, 10));
        System.out.println(hasPathSum2(root, 11));

    }

    private static boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        LinkedList<TreeNode> list = new LinkedList<>();
        LinkedList<Integer> values = new LinkedList<>();
        list.offer(root);
        values.offer(root.val);
        while (!list.isEmpty()) {
            TreeNode node = list.poll();
            Integer temp = values.poll();
            if (node.left == null && node.right == null) {
                if (temp == sum) {
                    return true;
                }
                continue;
            }
            if (node.left != null) {
                list.offer(node.left);
                values.offer(temp + node.left.val);
            }
            if (node.right != null) {
                list.offer(node.right);
                values.offer(temp + node.right.val);
            }
        }
        return false;
    }

    private static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
