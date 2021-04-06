package 二叉树;

import java.util.Deque;
import java.util.LinkedList;

public class TreeNodeSerialize {//层次遍历
    public String Serialize(TreeNode root){
        if(root==null) return new String();
        StringBuilder result=new StringBuilder();
        result.append('[');
        Deque<TreeNode> queue=new LinkedList<>();
        queue.add(root);

        TreeNode cur;
        while(!queue.isEmpty()){
            cur=queue.poll();
            if(cur!=null){
                result.append(cur.val);
                result.append(',');
               queue.add(cur.left);
               queue.add(cur.right);
            }
            else result.append("null,");
        }
        result.setLength(result.length() - 1);//去掉最后一个逗号
        result.append(']');
        return result.toString();
    }
    public TreeNode deserialize(String data) {
        if(data.length()<3) return null;
        String[] convertedData=data.substring(1,data.length()-1).split(",");
        TreeNode root= new TreeNode(Integer.valueOf(convertedData[0]));
        Deque<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        TreeNode cur;
        int idx=0;
        while(!queue.isEmpty()){
            cur=queue.remove();
            if(++idx>=convertedData.length) break;
            if(convertedData[idx].compareTo("null")!=0) {
                cur.left=new TreeNode(Integer.valueOf(convertedData[idx]));
                queue.add(cur.left);
            }
            if(++idx>=convertedData.length) break;
            if(convertedData[idx].compareTo("null")!=0) {
                cur.right=new TreeNode(Integer.valueOf(convertedData[idx]));
                queue.add(cur.right);
            }
        }
        return root;
    }
}
