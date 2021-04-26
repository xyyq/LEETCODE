package 链表;

public class SolutionYT001 {
   public ListNode revers(ListNode node){
       ListNode dummyHead = new ListNode(-1);
       dummyHead.next = node;
       ListNode tmp = dummyHead;
       while (tmp.next != null && tmp.next.next != null){
           ListNode back = tmp.next.next;
           ListNode prev = tmp.next;
           prev.next=back.next;
           tmp.next= back;
           back.next= prev;
           tmp = prev;
       }
       return dummyHead.next;
   }
}
