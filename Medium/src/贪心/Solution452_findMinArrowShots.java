package 贪心;

import java.util.Arrays;

public class Solution452_findMinArrowShots {
    public static void main(String[] args) {
        int[][] in={{-2147483646,-2147483645},{2147483646,2147483647}};

        System.out.println(new Solution452_findMinArrowShots().findMinArrowShots(in));
    }
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (p1, p2) -> p1[0] < p2[0] ? -1 : 1);
        int[] curr=points[0];
        int res=points.length;
        for (int i = 1; i < points.length; i++) {
            if (points[i][0]<=curr[1]&&curr[1]<=points[i][1]){
                res--;
                curr[0]=points[i][0];
            }else if (points[i][0]>curr[1]){
                curr=points[i];
            }else {
                curr=points[i];
                res--;
            }
        }
        return res;
    }
}
