package 二叉树;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution111_minDepth {
    public int minDepth(TreeNode root) {
        if (root==null) return 0;
        Deque<TreeNode> deque=new ArrayDeque<>();
        deque.add(root);
        int res=0;
        while (!deque.isEmpty()){
            int n=deque.size();
            res++;
            for (int i = 0; i < n; i++) {
                TreeNode node=deque.poll();
                if (node.left==null&&node.right==null) {
                    return res;
                }
                if(node.left!=null){
                    deque.add(node.left);
                }
                if(node.right!=null){
                    deque.add(node.right);
                }
            }
        }
        return res;
    }
}
