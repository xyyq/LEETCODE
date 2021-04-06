package 回溯;

import java.util.Arrays;

public class Solution132_minCut {
    public static void main(String[] args) {
        System.out.println(new Solution132_minCut().minCut("aab"));
    }
    public int minCut(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        boolean[][] st = new boolean[n][n];
        for (int j = 0; j < n; j++) {
            for (int i = j; i >=0 ; i--) {
                if (i == j){
                    st[i][j] = true;
                }else {
                    if (j - i == 1){
                        st[i][j] = chars[i] == chars[j];
                    }else {
                        st[i][j] = chars[i] == chars[j] && st[i + 1][j - 1];
                    }
                }
            }
        }
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            if (st[0][i]){
                dp[i] = 0;
            }else {
                for (int j = 1; j <= i; j++) {
                    if (st[j][i]){
                        dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                    }
                }
            }
        }
        return dp[n - 1];
    }
}
