package 二叉树;

import java.util.List;
import java.util.Stack;

public class Traversal {

    public void inorder(TreeNode root, List<Integer> res){//中序遍历迭代
        Stack<TreeNode> stack=new Stack<>();
        while (!stack.isEmpty()||root!=null){
            while (root!=null){
                stack.push(root);
                root=root.left;
            }
            TreeNode tmp=stack.pop();
            res.add(tmp.val);
            root=tmp.right;
        }
        return;
    }
    public void preorder(TreeNode root, List<Integer> res){
        Stack<TreeNode> stack=new Stack<>();
        while (!stack.isEmpty()||root!=null){
            while (root!=null){
                res.add(root.val);
                stack.push(root);
                root=root.left;
            }
            root=stack.pop().right;
        }
        return;
    }
    public void postorder(TreeNode root, List<Integer> res){
        Stack<TreeNode> stack=new Stack<>();
        while (!stack.isEmpty()||root!=null){

        }
    }

}
