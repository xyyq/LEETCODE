package 深度优先搜索;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution129 {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(4);
        root.left=new TreeNode(9);
        root.right=new TreeNode(0);
        TreeNode node1;
        node1=root.left;
        node1.left=new TreeNode(5);
        node1.right=new TreeNode(1);
        List<String> list=new ArrayList<>();
        String s="";
        dfs(root,0);
        System.out.println(res);
//        System.out.println(sumNumbers(root));
    }
    public  int sumNumbers(TreeNode root) {

        Stack<TreeNode> s=new Stack<>();
        s.push(root);
        String s1="";
        int ans=0;
        while (!s.isEmpty()){
            TreeNode node=s.pop();
            s1+=String.valueOf(node.val);
            int k=0;
            if (node.right!=null){
                s.push(node.right);
                k++;
            }
            if (node.left!=null){
                s.push(node.left);
                k++;
            }
            if (0==k){
                    ans+=Integer.parseInt(s1);
            }

        }
        return ans;
    }
    static int res=0;
    public  static void dfs(TreeNode node, int num){
        if (node.right==null&&node.left==null){
           res+=num*10+node.val;
           return;
        }
        num=num*10+node.val;
        dfs(node.left,num);
        dfs(node.right,num);
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }

}
