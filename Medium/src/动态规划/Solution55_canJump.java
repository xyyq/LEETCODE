package 动态规划;

public class Solution55_canJump {
    public boolean canJump(int[] nums) {
        int n=nums.length;
        int step=nums[0];
        for (int i = 1; i < n; i++) {
            if (step<i){
                return false;
            }
            step=Math.max(step,i+nums[i]);
            if (step>=n-1){
                return true;
            }
        }
        return true;
    }
}
