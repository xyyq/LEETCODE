package 数组;

public class Solution659_isPossible {
    public boolean isPossible(int[] nums) {
        int n=nums.length;
        //设当前数为x 前一个数为prev,dp1 为以prev结尾的长度为1的子序列数量，
        //dp2为以prev结尾的长度为2的子序列数量，dp3为以prev结尾的长度>=的子序列数量，
        int dp1=0,dp2=0,dp3=0;
        int i=0;
        while (i<n){
            int start=i;
            int x=nums[i];
            while (i<n&&nums[i]==x){
                i++;
            }
            int cnt = i - start;
            if (start > 0&&x != nums[start - 1] + 1){
                if (dp1+dp2>0){
                    return false;
                }else {
                    dp1=cnt;
                    dp2=dp3=0;
                }
            }else {
                if (dp1+dp2>cnt) return false;
                int left=cnt-dp1-dp2;
                int keep=Math.min(dp3,left);
                dp3=keep+dp2;
                dp2=dp1;
                dp1=left-keep;
            }
        }
        return dp1==0&&dp2==0;
    }
}
