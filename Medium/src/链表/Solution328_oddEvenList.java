package 链表;

public class Solution328_oddEvenList {
    public ListNode oddEvenList(ListNode head) {
        if(head==null||head.next==null||head.next.next==null){
            return head;
        }
        ListNode odd =head;
        ListNode even =head.next;
        while (even !=null&&even.next!=null){
            ListNode tmp = even.next;
            even.next= even.next.next;
            ListNode tmp2= odd.next;
            odd.next=tmp;
            tmp.next=tmp2;
            odd = odd.next;
            even = even.next;
        }
        return head;
    }
}
