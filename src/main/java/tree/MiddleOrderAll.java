package tree;

import common.TreeNode;

import java.util.Stack;

/**
 * Created by wangxiaomin03 on 17/8/8.
 */
public class MiddleOrderAll {
    public static void recursion(TreeNode root) {
        if (root == null) {
            return;
        }
        recursion(root.left);
        System.out.print(root.val + ",");
        recursion(root.right);
    }

    public static void noRecursion(TreeNode root) {
        TreeNode h = root;
        Stack<TreeNode> stack = new Stack<>();
        while (h != null || !stack.empty()) {
            while (h != null) {
                stack.push(h);
                h = h.left;
            }
            if (!stack.empty()) {
                h = stack.pop();
                System.out.print(h.val + ",");
                h = h.right;
            }

        }


    }


    public static void main(String[] arg) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        recursion(root);
        System.out.println();
        noRecursion(root);

    }
}
