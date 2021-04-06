package 二叉树;

public class Solution104_maxDepth {
    public static void main(String[] args) {
        String s="[1,2,3,4,null,null,5,null,null,null,null]";
        TreeNode root = new TreeNodeSerialize().deserialize(s);
        System.out.println(new Solution104_maxDepth().maxDepth11(root));
    }
    public int maxDepth(TreeNode root) {
        dfs(root,0);
        return max;
    }
    int max=0;
    public void dfs(TreeNode node, int depth){
        if (node==null) {
            max=depth>max?depth:max;
            return;
        }
        dfs(node.left,depth+1);
        dfs(node.right,depth+1);
    }
    public int maxDepth11(TreeNode root){
        if (root==null) {
            return 0;
        }else {
            int leftHight = maxDepth11(root.left);
            int rightHight = maxDepth11(root.right);
            return Math.max(leftHight,rightHight)+1;
        }

    }
}
