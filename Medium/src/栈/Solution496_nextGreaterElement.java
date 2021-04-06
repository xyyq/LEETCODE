package 栈;

import java.util.HashMap;
import java.util.Stack;

public class Solution496_nextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack=new Stack<>();
        HashMap<Integer,Integer> hm=new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty()&&nums2[i]>stack.peek()){
                hm.put(stack.pop(),nums2[i]);

            }
            stack.push(nums2[i]);
        }
        while (!stack.empty()){
            hm.put(stack.pop(),-1);
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i]=hm.get(nums1[i]);
        }
        return nums1;
    }
}
