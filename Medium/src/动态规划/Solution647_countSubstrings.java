package 动态规划;

public class Solution647_countSubstrings {
    public int countSubstrings(String s) {
        int n=s.length();
        boolean[][] dp=new boolean[n][n];
        int res=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (s.charAt(i)==s.charAt(j)&&(j-i<3||dp[i+1][j-1])){
                    dp[i][j]=true;
                    res++;
                }
            }
        }
        return res;
    }
}
