package 数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution56_merge {
    public static void main(String[] args) {
        int[][] ints ={{1,3},{2,6},{8,10},{15,18}};
         ints =new Solution56_merge().merge11(ints);
        System.out.println(Arrays.deepToString(ints));
    }
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        List<int[]> res=new ArrayList<>();
        Arrays.sort(intervals,( v1, v2)->(v1[0]-v2[0]));
       /* for (int i = 0; i < intervals.length; i++) {
            int L = intervals[i][0], R = intervals[i][1];
            if (res.size()==0||res.get(res.size()-1)[1]<L){
                res.add(new int[]{L,R});
            }else {
                res.get(res.size()-1)[1]=Math.max(res.get(res.size()-1)[1],R);
            }
        }*/

        for (int i = 0; i < intervals.length;) {
            int t = intervals[i][1];
            int j = i + 1;
            while (j < intervals.length && intervals[j][0] <= t) {
                t = Math.max(t, intervals[j][1]);
                j++;
            }
            res.add(new int[]{ intervals[i][0], t });
            i = j;
        }

        return res.toArray(new int[res.size()][]);
    }
    public int[][] merge11(int[][] intervals){
        int length = intervals.length;
        int[][] res = new int[length][];
        int r=0;
        for (int i = 0; i < length; ) {
            int t=intervals[i][1];
            int j=i+1;
            while (j<length&&intervals[j][0]<=t){
                t = Math.max(t, intervals[j][1]);
                j++;
            }
            res[r++] = new int[]{intervals[i][0],t};
            i = j;
        }
        int[][] rRes = new int[r][];
        System.arraycopy(res, 0, rRes, 0, r);
        return rRes;
    }
}
