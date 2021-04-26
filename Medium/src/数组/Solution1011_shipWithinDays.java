package 数组;

public class Solution1011_shipWithinDays {
    public int shipWithinDays(int[] weights, int D) {
        int  n = weights.length;
        int[] preSum = new  int[n];
        for (int i = 1; i < n; i++) {
            preSum[i] = preSum[i] + weights[i];
        }

    }
}
