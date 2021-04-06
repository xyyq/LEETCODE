package 链表;

public class Solution160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA=getLength(headA);
        int lengthB=getLength(headB);
        int diff=lengthA-lengthB;
        if (diff>0){
            while (diff--!=0){
                headA=headA.next;
            }
        }else {
            diff=Math.abs(diff);
            while (diff--!=0){
                headB=headB.next;
            }
        }
        while (headA!=null&&headB!=null){
            if (headA==headB){
                return headA;
            }else {
                headA=headA.next;
                headB=headB.next;
            }
        }
        return null;
    }
    public  int getLength(ListNode head){
        int length=0;
        while (head!=null){
            length++;
            head=head.next;
        }
        return length;
    }
}
