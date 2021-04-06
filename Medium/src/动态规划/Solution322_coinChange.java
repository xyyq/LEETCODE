package 动态规划;

import java.util.Arrays;

public class Solution322_coinChange {
    public static void main(String[] args) {
        int[] coins={1,2,5};
        System.out.println(new Solution322_coinChange().coinChange(coins,11));
    }
    public int coinChange(int[] coins, int amount) {
        int[] dp=new int[amount+1];
        Arrays.fill(dp,(amount+1));
        dp[0]=0;

        for (int i = 1; i <=amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j]<=i){
                    dp[i]=Math.min(dp[i],dp[i-coins[j]]+1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
