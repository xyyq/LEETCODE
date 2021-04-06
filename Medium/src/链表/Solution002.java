package 链表;

public class Solution002 {
    static  int carry=0;
    public static void main(String[] args) {
        int[] nums1={2,4,3};
        int[] nums2={5,6,2};
        ListNode node1=new makeListnod(nums1).getNode();
        ListNode node2=new makeListnod(nums2).getNode();
        ListNode p =new Solution002().addTwoNumbers2(node1,node2);
        while (p!=null){
            System.out.println(p.val);
            p=p.next;
        }

    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {//长度 不相同的链表 逆序数字相加   正序输出//243+123=366 236+1234=3594
       if (l1==null&&l2==null&&carry==0){
           return null;
       }
       int l=l1==null?0:l1.val;
       int r=l2==null?0:l2.val;
       int sum=l+r+carry;
       carry=sum/10;
       var node=new ListNode(sum%10);
       node.next=addTwoNumbers(l1!= null ? l1.next : null,l2 != null ? l2.next : null);
       return node;
    }
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {//长度 相同的链表 逆序数字相加   正序输出//243+123=663
       if (l1==null&&l2==null&&carry!=0){
            return new ListNode(1);
        }
        else if (l1.next==null&&l2.next==null&&(l1.val+l2.val+carry)<10){
            l1.val=l1.val+l2.val+carry;
            return l1;
        }
        int l=l1==null?0:l1.val;
        int r=l2==null?0:l2.val;
        int sum=l+r+carry;
        carry=sum/10;
        var node=new ListNode(sum%10);
        ListNode n1=addTwoNumbers2(l1!= null ? l1.next : null,l2 != null ? l2.next : null);
        ListNode tmp=n1;
        while (tmp.next!=null){
            tmp=tmp.next;
        }
        tmp.next=node;
        return n1;
    }
}
