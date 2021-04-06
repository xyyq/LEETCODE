package 二叉树;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution437_pathSum {
    public static void main(String[] args) {
        String s="[10,5,-3,3,2,null,11,3,-2,null,1]";
        TreeNode root = new TreeNodeSerialize().deserialize(s);
        System.out.println(new Solution437_pathSum().pathSum(root,8));
    }
    public int pathSum(TreeNode root, int sum) {
        int[] sumArr=new int[1001];
        return dfs(root,sumArr,sum,0);
    }
    public int dfs(TreeNode root, int[] sumArr,int sum,int depth){
        if (root==null) return 0;
        int count=0;
        int amount=0;
        sumArr[depth]= root.val;
        for (int i = depth; i >=0; i--) {
                amount += sumArr[i];
                if (amount==sum) count++;
        }
        int l1=dfs(root.left,sumArr,sum,depth+1);
        int r1=dfs(root.right,sumArr,sum,depth+1);
        return l1+r1+count;
    }
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {
        public int pathSum(TreeNode root, int sum) {
            return dfs(root,new ArrayList<>(),sum);
        }
        public int dfs(TreeNode root, List<Integer> list,int sum){
            if (root==null) return 0;
            List<Integer> sumList=list;
            list.replaceAll(t->t+root.val);
            list.add(root.val);
            int count=0;
            for (int x:list){
                if (x==sum){
                    count++;
                }
            }
            int l1=dfs(root.left,list,sum);
            int r1=dfs(root.right,list,sum);
            list.replaceAll(t->t-root.val);
            list.remove(list.size()-1);
            return l1+r1+count;
        }
    }
}
