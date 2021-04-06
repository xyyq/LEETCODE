package 二叉树;

public class Solution116 {
    public TreeNode connect(TreeNode root) {
        /*if (root==null){
            return root;
        }
        Queue<Node>  queue=new ArrayDeque<>();
        queue.add(root);
        while (queue!=null){
            int n=queue.size();
            for (int i = 0; i < n; i++) {
                Node node=queue.poll();
                if (i < n - 1) {
                    node.next = queue.peek();
                }

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return root;*/
        if (root==null){
            return root;
        }
        TreeNode leftMost = root;
        while (leftMost.left!=null){
            TreeNode tmp = leftMost;
            while (tmp!=null){
                tmp.left.next=tmp.right;
                if (tmp.next!=null){
                    tmp.right.next=tmp.next.left;
                }
                tmp=tmp.next;
            }
            leftMost=leftMost.left;
        }
        return root;
    }
}
