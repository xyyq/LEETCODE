package 二叉树;

import java.util.Stack;

public class Solution114_flatten {
    public void flatten(TreeNode root) {
       if (root==null) return;
       TreeNode tmp=root.right;
       flatten(root.left);
       root.right=root.left;
       root.left=null;
       while (root.right!=null){
           root=root.right;
       }
       flatten(tmp);
       root.right=tmp;
    }
}
