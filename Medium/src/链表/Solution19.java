package 链表;

public class Solution19 {
    public static void main(String[] args) {
        int[] nums={1,2,3,4,5};
        ListNode node=new makeListnod(nums).getNode();
        ListNode p=new Solution19().removeNthFromEnd(node,0);
        while (p!=null){
            System.out.println(p.val);
            p=p.next;
        }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        while (n--!=0){
            fast=fast.next;
        }
        while (fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
        return dummy.next;
    }
}
