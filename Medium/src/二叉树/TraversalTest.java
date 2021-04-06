package 二叉树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TraversalTest {
    public List<Integer> inTraversal(TreeNode node){
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (node != null || !stack.empty()){
            if (node != null){
                res.add(node.val);
                stack.push(node.right);
                node = node.left;
            }else {
                node = stack.pop();
            }
        }
        return res;
    }

    private void preOrder(TreeNode node, List<Integer> res) {
        if (node == null){
            return;
        }
        res.add(node.val);
        preOrder(node.left,res);
        preOrder(node.right,res);
    }

    private void inorder(TreeNode node, List<Integer> res) {
        if (node == null){
            return;
        }
        inorder(node.left,res);
        res.add(node.val);
        inorder(node.right,res);
    }


}
