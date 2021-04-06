package 数组;

public class Solution152_maxProduct {
    public static void main(String[] args) {
        int[] nums={2,3,-6,4,5,-100,4,5,-10};
        System.out.println(new Solution152_maxProduct().maxProduct(nums));
    }
    public int maxProduct(int[] nums) {
        int maxF = nums[0], minF = nums[0], ans = nums[0];
        int length = nums.length;
        for (int i = 1; i < length; ++i) {
            int mx = maxF, mn = minF;
            maxF = Math.max(mx * nums[i], Math.max(nums[i], mn * nums[i]));
            minF = Math.min(mn * nums[i], Math.min(nums[i], mx * nums[i]));
            ans = Math.max(maxF, ans);
        }
        return ans;

    }
}
