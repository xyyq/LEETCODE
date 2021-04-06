package 二叉树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution94_inorderTraversal {
    public static void main(String[] args) {
        String s="[1,2,3,4,null,null,5,null,null,null,null]";
        TreeNode root = new TreeNodeSerialize().deserialize(s);
        List<Integer> res=new Solution94_inorderTraversal().inorderTraversal(root);
        System.out.println("中序遍历:"+res);
        System.out.println("层次遍历:"+new Solution102_levelOrder().levelOrder(root));
        TreeNode node = new TreeNode(1);
        node.left=new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left=new TreeNode(4);
        node.right.right = new TreeNode(5);
        System.out.println("层次遍历序列化:"+new TreeNodeSerialize().Serialize(node));
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        inorder(root,res);
        return res;
    }
    public void inorder(TreeNode root, List<Integer> res){//递归
        if (root==null){
            return;
        }
        inorder(root.left,res);
        res.add(root.val);
        inorder(root.right,res);
    }
    public void inorderIteration(TreeNode root, List<Integer> res){
        Stack<TreeNode> s=new Stack<>();
        while (!s.empty()||root!=null){
            while (root!=null){
                s.push(root);
                root=root.left;
            }
            root = s.pop();
            res.add(root.val);
            root=root.right;
        }
    }
}
