package tree;

/**
 * Created by wangxiaomin03 on 17/7/31.
 */

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    public static void main(String[] arg) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.right=new TreeNode(5);
        List<Integer> r = postorderTraversal(root);
        for (Integer k : r) {
            System.out.print(k + ",");
        }
        ArrayList<Integer> result = new ArrayList<Integer>();
        postorderTraversal(root, result);
        System.out.println();
        for (Integer k : result) {
            System.out.print(k + ",");
        }
    }

    public static ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        TreeNode p = root;
        Stack<TreeNode> stack = new Stack<>();

        while (p != null) {
            stack.push(p);
            if (p.left != null) {
                p = p.left;
                stack.peek().left = null;

            } else if (p.right != null) {
                p = p.right;
                stack.peek().right = null;
            } else {
                result.add(stack.pop().val);
                if(stack.empty()){
                    p=null;
                }else {
                    p = stack.pop();
                }

            }

        }

        return result;
    }

    public static void postorderTraversal(TreeNode root, ArrayList<Integer> result) {
        if (root == null || result == null) {
            return;
        }
        if (root.left != null) {
            postorderTraversal(root.left, result);
        }
        if (root.right != null) {
            postorderTraversal(root.right, result);
        }
        result.add(root.val);
    }
}