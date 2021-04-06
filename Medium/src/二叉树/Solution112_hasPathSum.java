package 二叉树;

public class Solution112_hasPathSum {
    public static void main(String[] args) {
        String s="[5,4,8,11,null,9,4,7,1,null,null,null,1]";
        TreeNode root = new TreeNodeSerialize().deserialize(s);
        System.out.println(new Solution112_hasPathSum().hasPathSum(root,22));
    }
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root==null) return false;
        if (root.left==null&&root.right==null){
            return root.val==sum;
        }
        return hasPathSum(root.left,sum- root.val)||hasPathSum(root.right,sum- root.val);
    }
}
