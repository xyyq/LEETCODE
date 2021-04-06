package 链表;

public class Solution203 {
    public static void main(String[] args) {
        int[] nums={1,1,2,3,3,1,5,5,5,1};
        ListNode node=new makeListnod(nums).getNode();
        ListNode p=new Solution203().removeElements(node,1);
        while (p!=null){
            System.out.println(p.val);
            p=p.next;
        }
    }
    public ListNode removeElements(ListNode head, int val) {
           /* ListNode dummyHead = new ListNode(val+1);
            dummyHead.next=head;
            ListNode tmp=dummyHead;
            while (tmp.next!=null){
                if (tmp.next.val==val){
                    tmp.next=tmp.next.next;
                }else {
                    tmp=tmp.next;
                }
            }
            return dummyHead.next;*/
        if(head==null){
            return head;
        }
        head.next=removeElements(head.next,val);
        if(head.val==val){
            return head.next;
        }else{
            return head;
        }
    }
    public ListNode removeElements1(ListNode head, int val){//递归
        if (head==null){
            return head;
        }
       if (head.val!=val){
           head.next=removeElements1(head.next,val);
           return head;
       }else {
           return removeElements1(head.next,val);
       }
    }
}
