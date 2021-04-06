package 链表;

public class Solution143 {
    public static void main(String[] args) {
        int[] nums={1,2,3,4,5,6,7};
        ListNode node=new makeListnod(nums).getNode();
        new Solution143().reorderList(node);
        while (node!=null){
            System.out.println(node.val);
            node=node.next;
        }
    }
    private ListNode left;
    private boolean stop;
    public void reorderList(ListNode head) {
        left = head;
        stop = false;
        orderList(head);
    }

    //该方法作用是在指定条件下完成left指针和right指针的连接任务
    public void orderList(ListNode right){
        if(right == null) return;
        orderList(right.next);
        if(this.left == right || right.next == this.left){ //最后两指针相遇或错过时，left指针都指向尾结点
            left.next = null;   //防止出现环
            this.stop = true;   //stop为真时不做处理
        }

        if(!this.stop){
            ListNode succ = this.left.next;
            right.next = succ;
            this.left.next = right;
            this.left = succ;
        }
    }
}
