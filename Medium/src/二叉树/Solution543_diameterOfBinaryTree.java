package 二叉树;

public class Solution543_diameterOfBinaryTree {
    int res=1;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return res;
    }
    public int depth(TreeNode root){
        if (root==null)return 0;
        int L=depth(root.left);
        int R=depth(root.right);
        res = Math.max(res,L+R+1);
        return  Math.max(L,R)+1;
    }
}
