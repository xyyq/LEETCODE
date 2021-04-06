package 数组;

public class Solution1143_longestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int l1,l2;
        l1 = text1.length();
        l2 = text2.length();
        int[][] dp = new int[l1 + 1][l2 + 1];

        for (int i = 1; i <= l1; i++) {
            char c1 = text1.charAt(i - 1);
            for (int j = 1; j <= l2; j++) {
                if (c1 == text2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[l1][l2];
    }
}
