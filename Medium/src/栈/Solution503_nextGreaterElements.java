package 栈;

import java.util.Arrays;
import java.util.Stack;

public class Solution503_nextGreaterElements {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack=new Stack<>();
        int n=nums.length;
        int[] res=new int[n];
        Arrays.fill(res,-1);
        for (int i = 0; i <2*n-1; i++) {
            while (!stack.isEmpty() && nums[i % n] > nums[stack.peek()]) {
                
                res[stack.pop()] = nums[i % n];
            }
            stack.push(i);
        }
        return res;
    }
}
