package 链表;

public class Solution92Recur {

    public static void main(String[] args) {
        int[] nums={1,2,3,4,5,6,7};
        ListNode node=new makeListnod(nums).getNode();
        ListNode p=new Solution92Recur().reverseBetween(node,2,5);
        while (p!=null){
            System.out.println(p.val);
            p=p.next;
        }
    }
    ListNode reverseBetween(ListNode head, int m, int n){
        if (m==1){
            return reverseN(head,n);
        }
        head.next=reverseBetween(head.next,m-1,n-1);
        return head;
    }
    ListNode successor = null;
    ListNode reverseN(ListNode head , int n){//反转以以head为头结点的前n个节点
        if (n==1){
            successor = head.next;
            return head;
        }
        ListNode p=reverseN(head.next,n-1);
        head.next.next=head;
        head.next=successor;
        return p;
    }
}
