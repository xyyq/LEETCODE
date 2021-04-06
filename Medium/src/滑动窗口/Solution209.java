package 滑动窗口;

public class Solution209 {
    public static void main(String[] args) {
        int[] ints={2,3,1,2,4,3};
        System.out.println(new Solution209().minSubArrayLen(7, ints));
    }
    public int minSubArrayLen(int s, int[] nums) {
       /* int rk=-1;
        int ans=Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (i!=0){
                s+=nums[i-1];
            }
            while (rk+1<nums.length&&s>0){
                s-=nums[rk+1];
                rk++;
            }
            if (s<=0){
                ans=Math.min(ans,rk-i+1);
            }
        }
        return ans==Integer.MAX_VALUE?0:ans;*/
        int left=0,right=0;
        int ans=Integer.MAX_VALUE;
        int n=nums.length;
        int sum = 0;
        while (right<n){
            sum+=nums[right];
            right++;
            while (sum >= s) {
                ans = Math.min(ans, right - left);
                sum -= nums[left];
                left++;
            }

        }
        return ans==Integer.MAX_VALUE?0:ans;
    }
}
