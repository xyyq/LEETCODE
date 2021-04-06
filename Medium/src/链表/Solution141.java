package 链表;

public class Solution141 {
    public boolean hasCycle(ListNode head) {
        ListNode slow=head;
        ListNode fast=head.next;
        while (slow!=fast){
            if (fast==null||fast.next==null){
                return false;
            }
            slow=slow.next;
            fast=fast.next.next;
        }
        return true;
    }
}

