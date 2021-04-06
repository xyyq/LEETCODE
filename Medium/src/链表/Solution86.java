package 链表;

public class Solution86 {
    public static void main(String[] args) {
        int[] nums={1,4,3,2,5,2,6};
        ListNode node=new makeListnod(nums).getNode();
        ListNode p=new Solution86().partition(node,3);
        int k=0;
            while (p!=null&&k++<100){
            System.out.println(p.val);
            p=p.next;
        }
    }
    public ListNode partition(ListNode head, int x) {
        ListNode prev = new ListNode(-1);
        ListNode beh = new ListNode(-1);
        ListNode tmp1 =prev;
        ListNode tmp2 =beh;
        while(head!=null){
            if(head.val<x){
                tmp1.next=head;
                tmp1=tmp1.next;
            }else{
                tmp2.next=head;
                tmp2=tmp2.next;
            }
            head=head.next;
        }
        tmp2.next=null;
        tmp1.next=beh.next;
        return prev.next;
    }
}
