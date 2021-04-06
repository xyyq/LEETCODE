package 动态规划;

public class Solution115_numDistinct {
    public static void main(String[] args) {
        String s = "rabbbit";
        String t = "rabbit";
        System.out.println(new Solution115_numDistinct().numDistinct(s,t));
    }
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            if (s.charAt(i) == t.charAt(0)){
                dp[i][0] = 1;
            }
        }
        for (int i = 0; i < m; i++) {
            char c = s.charAt(i);
            for (int j = 1; j <= i && j < n ; j++) {
                if (c == t.charAt(j)){
                    for (int k = 0; k < i; k++) {
                        dp[i][j] += dp[k][j-1];
                    }
                }
            }
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            res += dp[i][n-1];
        }
        return  res;
    }
}
