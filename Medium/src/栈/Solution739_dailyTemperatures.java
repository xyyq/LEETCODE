package 栈;

import java.util.Stack;

public class Solution739_dailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack=new Stack<>();
        int[] ans = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            while (!stack.empty()&&T[i]>T[stack.peek()]){
                int pre=stack.pop();
                ans[pre]=i-pre;
            }
            stack.push(i);
        }
        return ans;
    }
}
