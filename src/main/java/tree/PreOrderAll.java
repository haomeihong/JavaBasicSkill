package tree;

import common.TreeNode;

import java.util.Stack;

/**
 * Created by wangxiaomin03 on 17/8/8.
 * 题目
 * 二叉树的先序遍历
 */
public class PreOrderAll {
    public static void noRecursion(TreeNode root) {
        TreeNode h = root;
        Stack<TreeNode> stack = new Stack<>();
        while (h != null || !stack.empty()) {
            while (h != null) {
                System.out.print(h.val + ",");
                stack.push(h);
                h = h.left;
            }
            if (!stack.empty()) {
                TreeNode p = stack.pop();
                h = p.right;
            }
        }
    }

    public static void noRecursion1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode h = stack.pop();
            System.out.print(h.val + ",");
            if (h.right != null) {
                stack.push(h.right);
            }
            if (h.left != null) {
                stack.push(h.left);
            }
        }

    }

    public static void recursion(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + ",");
        recursion(root.left);
        recursion(root.right);
    }

    public static void main(String[] arg) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        noRecursion(root);
        System.out.println();
        noRecursion1(root);
        System.out.println();
        recursion(root);

    }
}
