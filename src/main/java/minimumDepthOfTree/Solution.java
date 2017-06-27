package minimumDepthOfTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by wangxiaomin03 on 17/4/26.
 */
public class Solution {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public int run(TreeNode root){
        if(root==null){
            return 0;
        }
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.offer(root);
        int count=0;
        outter:while(!queue.isEmpty()){
            int size=queue.size();
            count++;
            while (size>0){
                TreeNode node=queue.poll();
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
                if(node.left==null&&node.right==null){
                    break outter;
                }
                size--;
            }
        }
        return count;
    }
    public static void main(String[] args){
        Solution solution=new Solution();
        TreeNode root=new TreeNode(0);
        root.left=new TreeNode(1);
        root.right=new TreeNode(2);
//        root.left.left=new TreeNode(3);
//        root.left.right=new TreeNode(4);
//        root.left.left.left=new TreeNode(4);
        root.right.left=new TreeNode(4);
        root.right.right=new TreeNode(4);
        System.out.print(solution.run(root));
    }
}
