package 链表;

public class Solution148 {
    public static void main(String[] args) {
        int[] nums={4,2,1,6,8};
        ListNode node=new makeListnod(nums).getNode();
        ListNode p=new Solution148().sortList(node);
        while (p!=null){
            System.out.println(p.val);
            p=p.next;
        }
    }
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;
        ListNode l=sortList(head);
        ListNode r=sortList(tmp);
        return  merge(l,r);
    }

    public ListNode merge(ListNode n1,ListNode n2){
        ListNode p=new ListNode(0);
        ListNode temp=p;
        while (n1!=null&&n2!=null){
            if (n1.val<=n2.val){
                temp.next=n1;
                temp=temp.next;
                n1=n1.next;
            }else if (n2.val<n1.val){
                temp.next=n2;
                temp=temp.next;
                n2=n2.next;
            }
        }
        if (n1!=null){
            temp.next=n1;
        }
        if (n2!=null){
            temp.next=n2;
        }
        return p.next;
    }

}
