package 二叉树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution144_preorderTraversal {
    public static void main(String[] args) {
        String s="[4,2,7,1,3,6,9]";
        TreeNode root = new TreeNodeSerialize().deserialize(s);
        List<Integer> res=new Solution144_preorderTraversal().preorderTraversalIter(root);
        System.out.println(res);
    }
    public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> res=new ArrayList<>();
            preorder(root,res);
            return res;

        }
        void preorder(TreeNode root,List<Integer> res){
            if (root==null) return ;
            res.add(root.val);
            preorder(root.left,res);
            preorder(root.right,res);
        }
    public List<Integer> preorderTraversalIter(TreeNode root){
        Stack<TreeNode> s=new Stack<>();
        List<Integer> res=new ArrayList<>();
        if (root == null) {
            return res;
        }

        s.push(root);

        while (!s.empty()){
            TreeNode tmp=s.pop();
            res.add(tmp.val);
            if (tmp.right!=null) s.push(tmp.right);
            if(tmp.left!=null ) s.push(tmp.left);
        }
        return res;
    }
}
