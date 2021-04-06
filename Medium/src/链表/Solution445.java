package 链表;

import java.util.Stack;

public class Solution445 {

    static  int carry = 0;
    public static void main(String[] args) {
        int[] nums1={1,8,5};
        int[] nums2={1,7};
        ListNode node1=new makeListnod(nums1).getNode();
        ListNode node2=new makeListnod(nums2).getNode();

        ListNode tmp1=node1;
        ListNode tmp2=node2;
        while (tmp1!=null||tmp2!=null){
            if (tmp1==null){
                ListNode node =new ListNode(0);
                node.next=node1;
                node1=node;
                tmp2=tmp2.next;
            }else if (tmp2==null){
                ListNode node =new ListNode(0);
                node.next=node2;
                node2=node;
                tmp1=tmp1.next;
            }else {
                tmp1=tmp1.next;
                tmp2=tmp2.next;
            }
        }
        ListNode p=new Solution445().addTwoNumbers12(node1,node2);
        System.out.println(carry);
        while (p!=null){
            System.out.println(p.val);
            p=p.next;
        }

    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1.next.next!=null&&l2.next.next == null){
            return l1.next;
        }
        if (l1.next.next == null && l2.next.next == null) {
            if (l1.next.val + l2.next.val > 10) {
                l1.val++;
            }
            l1.next.val = (l1.next.val + l2.next.val) %10;
            return l1;
        }
        l1.next = addTwoNumbers(l1.next, l2.next);
        l1.val+=(l1.next.val+l2.next.val)/10;
        l1.next.val=(l1.next.val+l2.next.val)%10;
        return l1;
    }
    public ListNode addTwoNumbers11(ListNode l1, ListNode l2){
        ListNode dummyHead = new ListNode(1);
        dummyHead.next = l1;
        ListNode tmp1 = dummyHead;
        l1= addTwoNumbers(tmp1.next,l2);

        if (l1.val+l2.val>=10){
            l1.val=(l1.val+l2.val)%10;
            return dummyHead;
        }else {
            l1.val=l1.val+l2.val;
            return dummyHead.next;
        }
    }
    public ListNode addTwoNumbers12(ListNode l1, ListNode l2){// 递归  长度相同情况下
                                                              // 已知前一位上 两个数相加的结果 和进位情况的话
                                                                // 这样就能求当前位 两个数相加的结果 和进位情况
                                                                //这样求得最后一位的结果的情况下   递归求解 yes
        if(l1.next==null&&l2.next==null){
            carry = (l1.val+l2.val)/10;
            l1.val=(l1.val+l2.val)%10;
            return l1;
        }
        l1.next=addTwoNumbers12(l1.next,l2.next);
        int num = l1.val+l2.val+carry;
        l1.val = num%10;
        carry = num/10;
        return l1;
    }
    public void addZero(ListNode l1,ListNode l2){// 给不同长度的链表前面补0对齐
                                                 // 值传递 不是引用传递  方法无效
        ListNode tmp1=l1;
        ListNode tmp2=l2;
        while (tmp1!=null||tmp2!=null){
            if (tmp1==null){
                ListNode node =new ListNode(0);
                node.next=l1;
                l1=node;
                tmp2=tmp2.next;
            }else if (tmp2==null){
                ListNode node =new ListNode(0);
                node.next=l2;
                l2=node;
                tmp1=tmp1.next;
            }else {
                tmp1=tmp1.next;
                tmp2=tmp2.next;
            }
        }
    }
    public ListNode addTwoNumbersStack(ListNode l1, ListNode l2){//使用栈结构
        Stack<Integer> stack1=new Stack<>();
        Stack<Integer> stack2=new Stack<>();
        while (l1!=null){
            stack1.push(l1.val);
            l1=l1.next;
        }
        while (l2!=null){
            stack2.push(l2.val);
            l2=l2.next;
        }
        ListNode res = new ListNode(1);
        ListNode p=res;
        int carry = 0;
        while (!stack1.empty()||!stack2.empty()||carry!=0){
            int l1Val=stack1.empty()?0:stack1.pop();
            int l2Val=stack2.empty()?0:stack2.pop();
            int num = l1Val+l2Val+carry;
            carry = num/10;
            ListNode tmp=new ListNode(num%10);
            p.next=tmp;
            p=p.next;
        }
            return res.next;

    }
}
