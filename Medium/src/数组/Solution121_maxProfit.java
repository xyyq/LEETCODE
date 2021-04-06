package 数组;

public class Solution121_maxProfit {
    public int maxProfit(int[] prices) {
        int  n=prices.length;
        int min=Integer.MAX_VALUE;
        int Profit=0;
        int currProfit;
        for (int i = 0; i < n; i++) {
            min=prices[i]<min?prices[i]:min;
            currProfit=prices[i]-min;
            Profit=currProfit>Profit?currProfit:Profit;
        }
        return Profit;
    }
}
