package 链表;

public class Solution82 {
    public static void main(String[] args) {
        int[] nums={1,1,2,3,5,5,5,6};
        ListNode node=new makeListnod(nums).getNode();
        ListNode p=new Solution82().deleteDuplicates1(node);
        while (p!=null){
            System.out.println(p.val);
            p=p.next;
        }
    }
    public ListNode deleteDuplicates(ListNode head) {//快慢指针
            if(head==null || head.next==null) {
                return head;
            }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next=head;
        ListNode tmp=dummyHead;
        while (tmp.next!=null&&tmp.next.next!=null){
            ListNode slow=tmp.next;
            ListNode fast=tmp.next.next;
            //tmp的后面两个节点值是否相等
            // 如果相等找到最后一个相等地方
            if (slow.val==fast.val){
                while (fast.next!=null&&fast.next.val==slow.val){
                    fast=fast.next;
                }
            //删除值相同段
                tmp.next=fast.next;
            }else {
                tmp=tmp.next;
            }
        }
        return dummyHead.next;
    }
    public ListNode deleteDuplicates1(ListNode head){//递归
        if(head==null || head.next==null) {
            return head;
        }
        if(head.val==head.next.val){
            while (head.next != null && head.val == head.next.val){
                head=head.next;
            }
            return deleteDuplicates1(head.next);
        }else {
           head.next= deleteDuplicates1(head.next);
           return head;
        }
    }
}
