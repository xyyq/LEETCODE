package 二叉树;

public class Solution235_lowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            while (true){
                if (root.val> p.val&&root.val>q.val){
                    root=root.left;
                }else if (root.val< p.val&&root.val<q.val){
                    root=root.right;
                }else {
                    break;
                }
            }
            return root;
    }
}
