package 二叉树;

public class Solution226_invertTree {
    public static void main(String[] args) {
        String s="[4,2,7,1,3,6,9]";
        TreeNode root = new TreeNodeSerialize().deserialize(s);
        root = new Solution226_invertTree().invertTree(root);
        System.out.println(new TreeNodeSerialize().Serialize(root));

    }
    public TreeNode invertTree(TreeNode root) {
        if (root==null) return  root;
        TreeNode tmp = invertTree(root.left);
        root.left=invertTree(root.right);
        root.right=tmp;
        return root;
    }
}
