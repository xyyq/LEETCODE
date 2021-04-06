package 数组;

import java.util.Arrays;
import java.util.Stack;

public class Solution456_find132pattern {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,Integer.MAX_VALUE);
        for (int i = 1; i < n; i++) {
            int x = nums[i];
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (nums[j] < x){
                    min = Math.min(min,nums[j]);
                }
            }
            dp[i] = min;
        }
        for (int i = 2; i < n; i++) {
            int x = nums[i];
            for (int j = 1; j < i; j++) {
                if (x < nums[j] && x > dp[j]) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean find132pattern02 (int[] nums){
        int n = nums.length;
        Stack<Integer> s =new Stack<>();
        int mid = Integer.MIN_VALUE;
        for (int i = n-1; i >=0 ; i--) {
            if (nums[i] < mid) return true;
            while (!s.empty() && s.peek() < nums[i]){
                mid = s.pop();
            }
            s.push(nums[i]);
        }
        return false;
    }
}
