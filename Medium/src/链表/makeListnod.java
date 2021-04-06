package 链表;

public class makeListnod {
    private ListNode node;
    public makeListnod(int[] nums){
        ListNode dummyHead=new ListNode(-1);
        ListNode temp=dummyHead;
        for (int i = 0; i < nums.length; i++) {
            temp.next=new ListNode(nums[i]);
            temp=temp.next;
        }
        node=dummyHead.next;
    }
    public ListNode getNode(){
        return node;
    }

}
