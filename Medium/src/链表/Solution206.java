package 链表;

import static java.lang.System.out;

public class Solution206 {
    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        ListNode p=head;
        for (int i = 1; i < 5; i++) {
            p.next=new ListNode(i+1);
            p=p.next;
        }
        head=new Solution206().reverseList1(head);
        while (head!=null){
            out.println(head.val);
            head=head.next;
        }
    }
    public ListNode reverseList(ListNode head) {
        if (head==null){
            return null;
        }
        if (head.next==null){
            return head;
        }
        ListNode p=reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;

    }
    public ListNode reverseList1(ListNode head) {
        /*ListNode prev = null;
        ListNode curr = head;
        while(curr!=null){
            ListNode temp=curr.next;
            curr.next=prev;//前变后
            prev=curr;//把当前节点 设置为中间节点
            curr=temp;//把后节点 设置为当前节点
        }
        return prev;*/
        ListNode prev = null;
        while(head!=null){
            ListNode temp=head.next;//保存当前节点的后面节点
            //将前面的节点接到当前节点后面
            //再将当前节点 设置成头节点（prev）
            //对后面的节点（temp）重复上诉操作
            head.next=prev;
            prev=head;
            head=temp;
        }
        return prev;
    }
}
