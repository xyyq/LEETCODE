package 二叉树;

import java.util.Stack;

public class Solution98_isValidBST {
    double prev=Double.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root==null) return true;
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        double pre=-Double.MAX_VALUE;
        while (!stack.isEmpty()||root!=null){
            while (root!=null){
                stack.push(root.left);
                root=root.left;
            }
            root=stack.pop();
            if (pre>=root.val){
                return false;
            }
            pre=root.val;
            root=root.right;
        }
        return true;
    }
    public boolean isValidBST22(TreeNode root){
        if (root==null) return true;
        if (!isValidBST22(root.left)){
            return false;
        }
        if (root.val<=prev){
            return false;
        }
        prev=root.val;
        if (!isValidBST22(root.right)){
            return false;
        }
        return true;
    }
}
