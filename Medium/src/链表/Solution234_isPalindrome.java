package 链表;

public class Solution234_isPalindrome {
    public static void main(String[] args) {
        int[] nums={1,3,2,1,2,3,4,5};
        ListNode node=new makeListnod(nums).getNode();
        System.out.println(new Solution234_isPalindrome().isPalindrome(node));
        new Solution234_isPalindrome().recursionPrint(node);
    }
    private ListNode frontPointer;
    private boolean recursivelyCheck(ListNode currentNode){
        if (currentNode != null) {
            if (!recursivelyCheck(currentNode.next)) return false;
            if (currentNode.val != frontPointer.val) return false;
            frontPointer = frontPointer.next;
        }
        return true;
    }
    public boolean isPalindrome(ListNode head) {
        frontPointer = head;
        return recursivelyCheck(head);
    }
    public void recursionPrint(ListNode head){//反向打印
        if (head==null) return;
        recursionPrint(head.next);
        System.out.println(head.val);
    }
}
