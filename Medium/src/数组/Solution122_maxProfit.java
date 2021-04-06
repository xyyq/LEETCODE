package 数组;

import java.util.Stack;

public class Solution122_maxProfit {
    public int maxProfit(int[] prices) {
        int  n=prices.length;
        int res=0;
        int left=0,right=0;
        while (left<n){
            right=left+1;
            int tmp=left;
            while (right<n&&prices[right]>=prices[left]){
                left++;
                right++;
            }
            res+=prices[right-1]-prices[tmp];
            left=right;
        }
        return res;
    }
}
