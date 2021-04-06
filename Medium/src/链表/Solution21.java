package 链表;

public class Solution21 {
    public static void main(String[] args) {
        ListNode head=new ListNode(0);
        ListNode p=head;
        for (int i = 2; i < 10; i++) {
            p.next=new ListNode(i);
            p=p.next;
            i++;
        }
        /*   head=new Solution148().sortList(head);*/
        ListNode head1=new ListNode(1);
        p=head1;
        for (int i = 3; i < 18; i++) {
            p.next=new ListNode(i);
            p=p.next;
            i++;
        }
        head=new Solution21().mergeTwoLists(head1,head);
        while (head!=null){
            System.out.println(head.val);
            head=head.next;
        }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode tmp=dummyHead;
        while (l1!=null&&l2!=null){
            if (l1.val<=l2.val){
                tmp.next=l1;
                l1=l1.next;
            }else {
                tmp.next=l2;
                l2=l2.next;
            }
           tmp=tmp.next;
        }
        if (l1!=null){
            tmp.next=l1;
        }
        if (l2!=null){
            tmp.next=l2;
        }
        return dummyHead.next;
    }
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2){//
        if (l1==null){
            return l2;
        }
        else if (l2==null){
            return l1;
        }else if (l1.val<=l2.val){
            l1.next=mergeTwoLists(l1.next,l2);
            return l1;
        }else {
            l2.next=mergeTwoLists(l1,l2.next);
            return l2;
        }

    }
}
