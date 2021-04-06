package 链表;

public class Solution23 {
    public ListNode mergeKLists(ListNode[] lists) {
        int n=lists.length;
        return merge(lists,0,n-1);
    }
    public ListNode merge(ListNode[] lists,int l,int r){
        if (l==r)return  lists[l];
        else if (l<r){
            int mid=(l+r)/2;
            ListNode left=merge(lists,l,mid);
            ListNode right=merge(lists,mid+1,r);
            return  mergeTwoLists(left,right);
        }else {
            return null;
        }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode tmp=dummyHead;
        while (l1!=null&&l2!=null){
            if (l1.val<=l2.val){
                tmp.next=l1;
                l1=l1.next;
            }else {
                tmp.next=l2;
                l2=l2.next;
            }
            tmp=tmp.next;
        }
        if (l1!=null){
            tmp.next=l1;
        }
        if (l2!=null){
            tmp.next=l2;
        }
        return dummyHead.next;
    }
}
