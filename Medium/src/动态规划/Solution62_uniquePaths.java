package 动态规划;

public class Solution62_uniquePaths {
    public int uniquePaths(int m, int n) {
        int[] dp=new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j==0||i==0){
                    dp[j]=1;
                }else {
                    dp[j]=dp[j]+dp[j-1];
                }
            }
        }
        return dp[n-1];
    }

}
