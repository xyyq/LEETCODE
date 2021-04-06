package 二叉树;

public class Solution101_isSymmetric {
    public boolean isSymmetric(TreeNode root){
        if(root==null) return true;
        if(root.left==null&&root.right==null) return true;
        return check(root.left, root.right);
    }
    public boolean check(TreeNode p,TreeNode q){
        if (p==null&&q==null) return true;
        if (p==null||q==null) return false;
        return q.val==p.val&&check(p.left,q.right)&&check(p.right,q.left);
    }
}
