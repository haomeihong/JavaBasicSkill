package tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by wangxiaomin03 on 17/8/3.
 * 题目
 * 二叉树的先序遍历
 */
public class PreOrder {


    public static ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
            result.add(node.val);
        }
        return result;
    }

    public static void main(String[] arg) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right=new TreeNode(4);
        root.right.left=new TreeNode(5);
        root.right.right=new TreeNode(6);
        ArrayList<Integer> list=preorderTraversal(root);
        for(Integer i:list){
            System.out.print(i+",");
        }
    }
}

