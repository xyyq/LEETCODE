package 二叉树;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution105_buildTree {
    public static void main(String[] args) {
        int[] pre={3,9,20,15,7};
        int[] inorder={9,3,15,20,7};
        System.out.println(new TreeNodeSerialize().Serialize(new Solution105_buildTree().buildTree(pre, inorder)));

    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {//r L R   (inorder)  L r[inDivide] R
          Map<Integer,Integer> map=new HashMap<>();
        int n=preorder.length;
        for (int i = 0; i <n ; i++) {
            map.put(inorder[i],i);
        }
        return build(preorder,inorder,map);
    }
    public TreeNode build(int[] preorder, int[] inorder, Map<Integer,Integer> map){
        int n=preorder.length;
        if(n==0) return null;
        int inDivide=0;
        TreeNode root=new TreeNode(preorder[0]);
        inDivide=map.get(preorder[0]);
        int[] preR=Arrays.copyOfRange(preorder,inDivide+1,n);
        int[] inR=Arrays.copyOfRange(inorder,inDivide+1,n);
        root.right=buildTree(preR,inR);
        int[] preL=Arrays.copyOfRange(preorder,1,inDivide+1);
        int[] inL=Arrays.copyOfRange(inorder,0,inDivide);
        root.left=buildTree(preL,inL);
        return root;
    }

}
