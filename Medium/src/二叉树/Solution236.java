package 二叉树;

import java.util.*;

public class Solution236 {
    TreeNode res;
    Map<Integer, TreeNode> parent = new HashMap<Integer, TreeNode>();
    Set<Integer> visited = new HashSet<Integer>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            dfs(root,p,q);
            return res;
    }
    public boolean dfs(TreeNode root,TreeNode p, TreeNode q){
        if (root==null) return false;
        boolean lson=dfs(root.left,p,q);
        boolean rson=dfs(root.right,p,q);
        if (lson&&rson||(root.val== q.val||root.val==p.val)&&(lson||rson)){
            res=root;
        }
        return lson||rson||(root.val==q.val||root.val== p.val);
    }
    public TreeNode lowestCommonAncestor22(TreeNode root, TreeNode p, TreeNode q){
        dfs(root);
        while (p!=null){
            visited.add(p.val);
            p=parent.get(p.val);
        }
        while (q!=null){
            if (visited.contains(q.val)){
                return q;
            }
            q=parent.get(q.val);
        }
        return null;

    }
    public void dfs(TreeNode root){
        if (root.left!=null){
            parent.put(root.left.val,root);
            dfs(root.left);
        }
        if (root.right!=null){
            parent.put(root.right.val,root);
            dfs(root.right);
        }
    }
}
