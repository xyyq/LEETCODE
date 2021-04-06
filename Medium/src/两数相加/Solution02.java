package 两数相加;

public class Solution02 {
    static  int carry=0;
    public static void main(String[] args) {
       ListNode l1=new ListNode(2);
        l1.next=new ListNode(4);
        ListNode l2=new ListNode(5);
        l2.next=new ListNode(6);
        ListNode ls= new Solution02().addTwoNumbers1(l1,l2);
        while (ls!=null){
            System.out.println(ls.val);
            ls=ls.next;
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry=0;
        while (l1!=null||l2!=null){
            int n1=l1!=null?l1.val:0;
            int n2=l2!=null?l2.val:0;
            int sum=n1+n2+carry;
            if (head==null){
                head=tail=new ListNode(sum%10);
            }else {
                tail.next=new ListNode(sum%10);
                tail=tail.next;
            }
            carry=sum/10;
            if (l1!=null){
                l1=l1.next;
            }
            if (l2!=null){
                l2=l2.next;
            }

        }
        if (carry!=0){
            tail.next=new ListNode(carry);
        }
        return head;
    }
    public ListNode addTwoNumbers11(ListNode l1, ListNode l2){
        if (l1==null&&l2==null&&carry==0){
            return null;
        }
        int l=l1==null?0:l1.val;
        int r=l2==null?0:l2.val;
        int sum=l+r+carry;
        carry=sum/10;
        var node=new ListNode(sum%10);
        ListNode node1=addTwoNumbers(l1!= null ? l1.next : null,l2 != null ? l2.next : null);
        node1.next=node;
        return node1;
    }
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2){
        if (l1==null&&l2==null&&carry==0){
            return null;
        }
        int l=l1==null?0:l1.val;
        int r=l2==null?0:l2.val;
        int sum=l+r+carry;
        carry=sum/10;
        var node=new ListNode(sum%10);
        ListNode node1=addTwoNumbers(l1!= null ? l1.next : null,l2 != null ? l2.next : null);
        node1.next=node;
        return node1;
    }

}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
