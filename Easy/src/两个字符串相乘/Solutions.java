package 两个字符串相乘;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solutions {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        Queue<TreeNode> Q = new ArrayDeque<>();
        Q.add(root);
        while (!Q.isEmpty()){
            int n=Q.size();
            List<Integer> list=new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode node = Q.poll();
                list.add(node.val);
                if (node.left != null) {
                    Q.add(node.left);
                }
                if (node.right != null) {
                    Q.add(node.right);
                }
            }
            res.add(list);
        }
        return res;
    }
}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
