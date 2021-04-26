package 数组;

import java.util.Arrays;

public class Solution1011_shipWithinDays {
    public int shipWithinDays(int[] weights, int D) {
        int  n = weights.length;
        int l = Arrays.stream(weights).max().getAsInt(), r = Arrays.stream(weights).sum();
        while (l < r){
            int  mid = l + (r - l) / 2;
            int need = 1;
            int curr = 0;
            for (int i = 0; i < n; i++) {
                if (curr + weights[i] > mid){
                    need++;
                    curr = 0;
                }
                curr += weights[i];
            }
            if (need <= D){
                r = mid;
            }else {
                l = mid + 1;
            }
        }
        return  l;
    }
}
