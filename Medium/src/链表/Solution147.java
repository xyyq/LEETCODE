package 链表;

public class Solution147 {
    public static void main(String[] args) {
        int[] nums={1,5,5,6,1,2,3,5};
        ListNode node=new makeListnod(nums).getNode();
        ListNode node1=new ListNode(5);
        ListNode p =new Solution147().insert(node);
        while (p!=null){
            System.out.println(p.val);
            p=p.next;
        }
    }
    public ListNode insertionSortList(ListNode head) {
        ListNode res=new ListNode(-1);
        ListNode tmp;
        while (head!=null){
            ListNode pre=res;
             tmp=head.next;
            head.next=null;
            while (pre.next!=null&&pre.next.val<head.val){
                pre=pre.next;
            }
            head.next=pre.next;
            pre.next=head;
            head=tmp;
        }
        return res.next;
    }
    public ListNode insert(ListNode head){
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = head.next;
        ListNode pre = head;
        while (cur!=null){
            ListNode temp = cur.next;
            if (cur.val<pre.val){
                ListNode start = dummy;
                while (cur.val>start.next.val){
                    start = start.next;
                }
                pre.next = cur.next;
                cur.next = start.next;
                start.next = cur;

                cur = temp;
            }
            else {
                cur = cur.next;
                pre = pre.next;
            }

        }
        return dummy.next;
    }
}
