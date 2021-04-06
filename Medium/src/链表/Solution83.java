package 链表;

public class Solution83 {
    public static void main(String[] args) {
    int[] nums={1,1,2,3,3,3,5,5,5,5};
    ListNode node=new makeListnod(nums).getNode();
    ListNode p=new Solution83().deleteDuplicatesRecur(node);
        while (p!=null){
        System.out.println(p.val);
        p=p.next;
    }
    }
    public ListNode deleteDuplicates(ListNode head) {
        ListNode tmp = head;
        while (tmp!=null&&tmp.next != null){
            if (tmp.val==tmp.next.val){
                tmp.next=tmp.next.next;
            }else {
                tmp=tmp.next;
            }

        }
        return head;
    }
    public ListNode deleteDuplicatesRecur(ListNode head){
        if (head==null||head.next==null) return head;
        if (head.val==head.next.val) {
            head.next=deleteDuplicates(head.next.next);

        }else {
            head.next=deleteDuplicates(head.next);
        }
        return head;
    }
}
