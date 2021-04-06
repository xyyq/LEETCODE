package 链表;

public class Solution142 {
    public ListNode detectCycle(ListNode head) {
        if (head==null||head.next==null){
            return null;
        }
        ListNode slow=head;
        ListNode fast=head;
        while (fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if (slow==fast){
                while (head!=slow){
                    slow= slow.next;
                    head=head.next;
                }
                return head;
            }
        }
        return null;
    }
}
