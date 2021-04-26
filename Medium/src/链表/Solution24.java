package 链表;

public class Solution24 {
    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        ListNode p=head;
        for (int i = 1; i < 5; i++) {
            p.next=new ListNode(i+1);
            p=p.next;
        }
        head=new Solution24().swapPairs(head);
        while (head!=null){
            System.out.println(head.val);
            head=head.next;
        }
    }
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode temp = dummyHead;
        while (temp.next!=null&&temp.next.next!=null){
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            temp.next=node2;
            node1.next=node2.next;
            node2.next=node1;
            temp=node1;
        }
        return dummyHead.next;
    }
    public ListNode swapPairs1(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs1(next.next);
        next.next = head;
        return next;
    }
}

