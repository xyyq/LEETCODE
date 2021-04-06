package 回溯;

public class Solution494_findTargetSumWays {
    public static void main(String[] args) {
        int[] nums={1,1,1,1,1};
        System.out.println(new Solution494_findTargetSumWays().findTargetSumWays1(nums, 3));
    }
    int res=0;
    public int findTargetSumWays(int[] nums, int S) {
        dfs(nums,0,S,0);
        return res;
    }
    public void dfs(int[] nums,int depth,int S,int sum){
       if (depth==nums.length){
           if (sum==S){
               res++;
           }
       }else {
           dfs(nums,depth+1,S,sum+nums[depth]);
           dfs(nums,depth+1,S,sum-nums[depth]);
       }
    }
    public int findTargetSumWays1(int[] nums, int S) {
        int[][] dp=new int[nums.length][13];
        dp[0][nums[0]+6] = 1;
        dp[0][-nums[0]+6] += 1;
        for (int i = 1; i < nums.length; i++) {
            for (int sum =-6; sum < 7; sum++) {
                if (dp[i-1][sum+6]>0){
                    dp[i][sum+nums[i]+6]+=dp[i-1][sum+6];
                    dp[i][sum-nums[i]+6]+=dp[i-1][sum+6];
                }
            }
        }
        return S > 6 ? 0 : dp[nums.length - 1][S + 6];
    }
}
