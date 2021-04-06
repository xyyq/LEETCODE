

public class Solution530 {
    int res = Integer.MAX_VALUE;
    int pre = -1;

    public static void main(String[] args) {

    }


    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return res;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (pre == -1) {
            pre = root.val;
        } else {
            res = Math.min(root.val - pre, res);
            pre = root.val;
        }
        dfs(root.right);
    }

}
class TreeNode {
   int val;
   TreeNode left;
   TreeNode right;
   TreeNode(int x) { val = x; }
}
