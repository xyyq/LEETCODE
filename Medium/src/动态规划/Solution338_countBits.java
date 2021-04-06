package 动态规划;

public class Solution338_countBits {
    public int[] countBits(int num) {
        int[] dp=new int[num+1];
        dp[0]=0;
        int k=1;
        int i=0;
        while (k<=num){
            while (i<k&&i+k<=num){
                dp[i+k]=dp[i]+1;
                i++;
            }
            i=0;
            k<<=1;
        }
        return dp;
    }
    public int[] countBits2(int num){
        int[] res=new int[num+1];
        res[0]=0;
        for (int i = 1; i < num+1; i++) {
            if ((i&1)==1){
                res[i]=res[i-1]+1;
            }else {
                res[i]=res[i/2];
            }
        }
        return res;
    }
}
