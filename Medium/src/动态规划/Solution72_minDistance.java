package 动态规划;

public class Solution72_minDistance {
    public int minDistance(String word1, String word2) {
            int X=word1.length();
            int Y=word2.length();
            int[][] dp=new int[X+1][Y+1];
            for (int i = 0; i < X+1; i++) {
                dp[i][Y]=X-i;
            }
            for (int i = 0; i < Y+1; i++) {
                dp[X][i]=Y-i;
            }
            for (int i = X-1; i>=0;i--) {
                for (int j = Y-1; j >=0 ; j--) {
                    int down=dp[i][j+1]+1;
                    int right=dp[i+1][j]+1;
                    int right_down=dp[i+1][j+1];
                    if (i<X-1&&j<Y-1&& word1.charAt(i + 1) != word2.charAt(j + 1)) {
                        right_down += 1;
                    }
                    dp[i][j]=Math.min(down,Math.min(right,right_down));
                }
            }
            return dp[0][0];
    }
}
