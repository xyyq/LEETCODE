package 二叉树;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution103_zigzagLevelOrder {
    public static void main(String[] args) {
        String s="[3,9,20,null,null,15,7]";
        TreeNode root = new TreeNodeSerialize().deserialize(s);
        System.out.println(new Solution103_zigzagLevelOrder().zigzagLevelOrder(root));
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        if (root==null){
            return res;
        }
        queue.add(root);
        int i = 0;
        while (!queue.isEmpty()){
            List<Integer> tmp=new ArrayList<>();
            Deque<TreeNode> queueTmp = new LinkedList<>();
             int size = queue.size();
            for (int j = 0; j < size; j++) {
                TreeNode node = queue.pop();
                if (i % 2 != 0) {
                    tmp.add(0,node.val);
                }else {
                    tmp.add(node.val);
                }

                if (node.left!=null){
                    queueTmp.add(node.left);
                }
                if (node.right!=null){
                    queueTmp.add(node.right);
                }
            }
            res.add(tmp);
            queue = queueTmp;
            i++;
        }
        return res;
    }
}
