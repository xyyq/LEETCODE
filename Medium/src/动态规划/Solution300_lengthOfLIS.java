package 动态规划;

public class Solution300_lengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        dp[0]=1;
        int max=1;
        for (int i = 1; i < n; i++) {
            dp[i]=1;
            for (int j = 0; j < i; j++) {
                if (nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            max=Math.max(dp[i],max);
        }
        return max;
    }
}
