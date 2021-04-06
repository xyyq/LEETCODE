package 链表;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Solution143_reorderList {
    public static void main(String[] args) {
        int[] nums={1,2,3,4,5,6,7};
        ListNode node=new makeListnod(nums).getNode();
        new Solution143_reorderList().reorderListPoint(node);
        while (node!=null){
            System.out.println(node.val);
            node=node.next;
        }
    }
    public void reorderList(ListNode head) {
        if (head==null||head.next==null)return;
        Deque<ListNode>  tmp=new LinkedList<>();
        ListNode next = head.next;
        while (next!=null){
            tmp.add(next);
            next=next.next;
        }
        while (!tmp.isEmpty()){
            head.next=tmp.pollLast();
            head=head.next;
            if (!tmp.isEmpty()){
                head.next=tmp.pollFirst();
                head=head.next;
            }

        }
        head.next=null;
    }
    public void reorderListPoint(ListNode head){//双指针

        if (head==null||head.next==null)return;
        Deque<ListNode>  tmp=new LinkedList<>();
        ListNode s=head;
        while (s!=null){
            ListNode l=s.next;
            s.next=null;
            tmp.add(s);
            s=l;
        }
        ListNode dummyHead = new ListNode(-1);
        ListNode helper=dummyHead;
        for (int i = 0,k=tmp.size()-1; i<=k ; i++,k--) {
                helper.next=tmp.pollFirst();
                helper.next.next=tmp.pollLast();
                helper=helper.next.next;
        }
        head=dummyHead.next;
    }

}
