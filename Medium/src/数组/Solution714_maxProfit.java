package 数组;

public class Solution714_maxProfit {
    public int maxProfit(int[] prices, int fee) {
        if (prices.length<2){
            return 0;
        }
        int min = prices[0];
        int res=0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i]<min){
                min = prices[i];
            }else {
                if (prices[i]-fee>min){
                    res += prices[i] - fee - min;
                    min = prices[i] - fee;
                }
            }
        }
        return res;
    }
    public int maxProfit2(int[] prices, int fee){
        if (prices.length<2){
            return 0;
        }
       // int[][] dp=new int[prices.length][2];
        int sell = 0;//不持有股票时利润
        int buy = -prices[0];//持有股票时利润

        for (int i = 1; i < prices.length; i++) {
           /* dp[i][0] = Math.max(dp[i - 1][0], prices[i] + dp[i - 1][1] - fee);前一天不持有 和前一天持有今天卖出
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]); 前一天持有 和前一天不持有今天持有*/
            sell = Math.max(sell, prices[i] + buy - fee);
            buy = Math.max(buy, sell - prices[i]);
        }
        return sell;
    }
}
