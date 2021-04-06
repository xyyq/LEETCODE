package 动态规划;

public class Solution64_minPathSum {
    public static void main(String[] args) {
        int[][] grid= {{1,2},{5,6},{1,1}};
        System.out.println(new Solution64_minPathSum().minPathSum(grid));
    }
    public int minPathSum(int [][] grid) {
        int n=grid[0].length;
        int[] dp=new int[n];
        dp[0]=grid[0][0];
        for (int i = 1; i < n; i++) {
            dp[i]=grid[0][i]+dp[i-1];
        }
        for (int i = 1; i < grid.length; i++) {
            dp[0]=grid[i][0]+dp[0];
            for (int j = 1; j < n; j++) {
                dp[j]=Math.min(dp[j-1],dp[j])+grid[i][j];
            }
        }
        return dp[n-1];
    }
}
