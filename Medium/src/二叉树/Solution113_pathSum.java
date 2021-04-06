package 二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution113_pathSum {
    public static void main(String[] args) {
        String s="[5,4,8,11,null,13,4,7,2,null,null,5,1]";
        TreeNode root = new TreeNodeSerialize().deserialize(s);
        System.out.println(new Solution113_pathSum().pathSum(root, 22));
    }
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res=new ArrayList<>();
        dfs(res,new LinkedList<>() ,sum,root);
        return res;
    }
    public  void dfs(List<List<Integer>> res,List<Integer> path,int sum,TreeNode root){
        if (root==null){
            return;
        }
        path.add(root.val);
        if (root.left == null && root.right == null && sum == root.val){
            res.add(new LinkedList<>(path));
            path.remove(path.size()-1);
            return;
        }
        dfs(res,path,sum- root.val,root.left);
        dfs(res,path,sum- root.val,root.right);
        path.remove(path.size()-1);
    }
}
