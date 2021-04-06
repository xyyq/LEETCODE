package 动态规划;

public class Solution198_rob {
    public int rob(int[] nums) {
        int n=nums.length;
        if (nums == null||n==0) return 0;
        if (n==1) return nums[0];
       int first=nums[0];
       int second=Math.max(nums[0],nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int tmp=second;
            second=Math.max(first+nums[i],second);
            first=tmp;
        }
        return second;
    }
}
