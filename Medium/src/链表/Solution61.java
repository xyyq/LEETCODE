package 链表;

public class Solution61 {
    public static void main(String[] args) {
        int[] nums={1,2,3,4,5};
        ListNode node=new makeListnod(nums).getNode();
        ListNode p=new Solution61().rotateRight(node,5);
        int k=0;
        while (p!=null&&k++<100){
            System.out.println(p.val);
            p=p.next;
        }
    }
    public ListNode rotateRight(ListNode head, int k) {
        ListNode tmp=head; int length=1;
        while(tmp.next!=null){
            tmp=tmp.next;
            length++;
        }
        tmp.next=head;
        k=length-k%length;
        while (k--!=1){
            head=head.next;
        }
        tmp=head.next;
        head.next=null;
        return tmp;
    }
}
