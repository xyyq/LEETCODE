package 动态规划;

public class Solution516_longestPalindromeSubseq {
    public int longestPalindromeSubseq(String s) {
        int n=s.length();
        int[][] dp=new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i]=1;
        }
      int i=0,j=0,k=1;
        while (k<n){
            j=i+k;
            while (j<n){
                if (s.charAt(i)==s.charAt(j)){
                  dp[i][j]=Math.max(dp[i+1][j-1]+2,Math.max(dp[i][j-1],dp[i+1][j]));
                }else {
                    dp[i][j]=Math.max(dp[i][j-1],dp[i+1][j]);
                }
                i++;
                j++;
            }
            i=0;
            k++;
        }
        return dp[0][n-1];
    }
}
