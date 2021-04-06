package 动态规划;

public class Solution746_minCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int first,second;
        first = cost[0];
        second = cost[1];
        int tmp;
        for (int i = 2; i < cost.length; i++) {
            tmp = second;
            second = Math.min(first,second)+cost[i];
            first = tmp;
        }
        return Math.min(first,second);
    }
}
